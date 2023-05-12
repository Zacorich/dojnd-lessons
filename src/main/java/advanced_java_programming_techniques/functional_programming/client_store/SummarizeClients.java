package advanced_java_programming_techniques.functional_programming.client_store;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public final class SummarizeClients {
    public static void main(String[] args) {

        int numClients = 0;
        int totalQuarterlySpend = 0;
        UdacisearchClient nextExpiration = null;
        Set<ZoneId> representedZoneIds = new HashSet<>();
        Map<Year, Integer> contractsPerYear = new HashMap<>();

        for (UdacisearchClient client : ClientStore.getClients()) {
            numClients++;
            totalQuarterlySpend += client.getQuarterlyBudget();
            if (nextExpiration == null || client.getContractStart().plus(client.getContractLength())
                    .isBefore(nextExpiration.getContractStart().plus(nextExpiration.getContractLength()))) {
                nextExpiration = client;
            }
            for (ZoneId zone : client.getTimeZones()) {
                representedZoneIds.add(zone);
            }
            contractsPerYear.compute(getContractYear(client), (k, v) -> (v == null) ? 1 : v + 1);
        }

        System.out.println("Num clients: " + numClients);
        System.out.println("Total quarterly spend: " + totalQuarterlySpend);
        System.out.println("Average budget: " + (double) totalQuarterlySpend / numClients);
        System.out.println("ID of next expiring contract: " + (nextExpiration == null ? -1 : nextExpiration.getId()));
        System.out.println("Client time zones: " + representedZoneIds);
        System.out.println("Contracts per year: " + contractsPerYear);


        //same as above result but using Stream API instead
        System.out.println("Num clients: " + ClientStore.getClients().size());

        //map each budget value to a result stream and terminate that stream with the sum() termination operation
        //to get total sum which sues associative accumulator function(which also can be used in parallel)
        System.out.println("(Stream)Total quarterly spend: " +
                ClientStore.getClients().stream().mapToInt(UdacisearchClient::getQuarterlyBudget).sum());

        //map all budgets and call average() operation on the stream to get OptionalDobule and terminate it with orElse(0)
        //operation if for example there is no any budgets in the stream
        System.out.println("(Stream)Average budget: " +
                ClientStore.getClients().stream().mapToInt(UdacisearchClient::getQuarterlyBudget).average().orElse(0));

        //create sorted stream comparing the contracts start plus the contract length of each client so that findFirst optional operation
        //will return the earliest Instant and matToLong in between to get IDs of each client;
        //the lambda expression can be simplified further using Comparator.comparing(c -> c...) so that to define the look inside of only
        //one client object; as an extra sorting feature is I move up client with the earliest contract start date
        //My solutions:
        System.out.println("(Stream)ID of next expiring contract: " + ClientStore.getClients().stream().sorted(
                (c1, c2) -> c1.getContractStart().plus(c1.getContractLength()).compareTo(c2.getContractStart().plus(c2.getContractLength()))).
                mapToLong(UdacisearchClient::getId).findFirst().orElse(-1));
        System.out.println("(Stream)ID of next expiring contract: " + ClientStore.getClients().stream().sorted(
                        Comparator.comparing(c -> c.getContractStart().plus(c.getContractLength())))
                        .sorted(Comparator.comparing(UdacisearchClient::getContractStart)).
                mapToLong(UdacisearchClient::getId).findFirst().orElse(-1));
        System.out.println("(Stream)ID of next expiring contract: " + ClientStore.getClients().stream().sorted(
                        Comparator.comparing(c -> c.getContractEnd()))
                .sorted(Comparator.comparing(UdacisearchClient::getContractStart)).
                mapToLong(UdacisearchClient::getId).findFirst().orElse(-1));
        System.out.println("(Stream)ID of next expiring contract: " + ClientStore.getClients().stream().sorted(
                        Comparator.comparing(UdacisearchClient::getContractEnd))
                .sorted(Comparator.comparing(UdacisearchClient::getContractStart)).
                mapToLong(UdacisearchClient::getId).findFirst().orElse(-1));
        //Udacity solution:
        System.out.println("(Stream)ID of next expiring contract: " + ClientStore.getClients().stream()
                .min(Comparator.comparing(UdacisearchClient::getContractEnd)).map(UdacisearchClient::getId).orElse(-1L));

        //need to map each list of timezones of each client into stream then run flatMap on the result stream so to
        //process each list of timezone of each client as a stream on it own and append results to a final result stream
        //containing all timezones and finally terminalte stream with the Collector.toSet to get rid of any duplicates
        //My solution:
        System.out.println("(Stream)Client time zones: " +
                ClientStore.getClients().stream().map(UdacisearchClient::getTimeZones).flatMap(List::stream).collect(Collectors.toSet()));
        //Udacity solutions:
        System.out.println("(Stream)Client time zones: " +
                ClientStore.getClients().stream().flatMap(c -> c.getTimeZones().stream()).distinct().collect(Collectors.toList()));
        System.out.println("(Stream)Client time zones: " +
                ClientStore.getClients().stream().flatMap(c -> c.getTimeZones().stream()).collect(Collectors.toSet()));

        //create stream of client and use collect operation that uses Collectors.groupingBy collector which first groups
        //by classifier where we actually call a static method of getContractYear which works nicely as it accepts UdacisearchClient
        //class and implicitly downstream is created for each classifier that does reduction using collector Collectors.counting()
        System.out.println("(Stream)Contracts per year: " +
                ClientStore.getClients().stream().collect(Collectors.groupingBy(SummarizeClients::getContractYear,
                        Collectors.counting())));
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate =
                LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}
