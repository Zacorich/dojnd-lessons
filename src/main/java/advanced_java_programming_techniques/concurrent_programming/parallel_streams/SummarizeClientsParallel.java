package advanced_java_programming_techniques.concurrent_programming.parallel_streams;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public final class SummarizeClientsParallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<UdacisearchClient> clients = ClientStore.getClients();
        int numClients = clients.size();

        // TODO: Create a ForkJoinPool to use as a thread pool.
        ForkJoinPool pool = new ForkJoinPool();
        // TODO: For each metric below, turn it into a Future and submit it to the ForkJoinPool.
//        int totalQuarterlySpend =
//                clients
//                        .stream()
//                        .mapToInt(UdacisearchClient::getQuarterlyBudget)
//                        .sum();
        Future<Integer> totalQuarterlySpend = pool.submit(
                () -> clients.parallelStream().mapToInt(UdacisearchClient::getQuarterlyBudget).sum());

//        double averageBudget =
//                clients
//                        .stream()
//                        .mapToDouble(UdacisearchClient::getQuarterlyBudget)
//                        .average()
//                        .orElse(0);
        Future<Double> averageBudget = pool.submit(
                () -> clients.parallelStream().mapToDouble(UdacisearchClient::getQuarterlyBudget).average().orElse(0)
        );

//        long nextExpiration =
//                clients
//                        .stream()
//                        .min(Comparator.comparing(UdacisearchClient::getContractEnd))
//                        .map(UdacisearchClient::getId)
//                        .orElse(-1L);
        Future<Long> nextExpiration = pool.submit(
                () -> clients.parallelStream().min(Comparator.comparing(UdacisearchClient::getContractEnd)).map(UdacisearchClient::getId).orElse(-1L)
        );

//        List<ZoneId> representedZoneIds =
//                clients
//                        .stream()
//                        .flatMap(c -> c.getTimeZones().stream())
//                        .distinct()  // Or use Collectors.toSet()
//                        .collect(Collectors.toList());
        ForkJoinTask<Set<ZoneId>> representedZoneIds = pool.submit(
                () -> clients.parallelStream().flatMap(c -> c.getTimeZones().stream()).collect(Collectors.toSet())
        );

//        Map<Year, Long> contractsPerYear =
//                clients
//                        .stream()
//                        .collect(Collectors.groupingBy(SummarizeClientsParallel::getContractYear, Collectors.counting()));
        Future<Map<Year, Long>> contractsPerYear = pool.submit(
                () -> clients.parallelStream().collect(Collectors.groupingBy(SummarizeClientsParallel::getContractYear, Collectors.counting()))
        );

        pool.shutdown();
        System.out.println("Num clients: " + numClients);

        // TODO: You will need to call Future#get() on each of the futures to return the actual
        //       computed value.
        System.out.println("Total quarterly spend: " + totalQuarterlySpend.get());
        System.out.println("Average budget: " + averageBudget.get());
        System.out.println("ID of next expiring contract: " + nextExpiration.get());
        System.out.println("Client time zones: " + representedZoneIds.get());
        System.out.println("Contracts per year: " + contractsPerYear.get());
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate =
                LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}