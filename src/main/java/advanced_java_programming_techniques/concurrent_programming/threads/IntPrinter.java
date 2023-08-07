package advanced_java_programming_techniques.concurrent_programming.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class IntPrinter {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main <number of threads>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // TODO: Create a list of n Threads and run them all in parallel with the System.out.println
        //       statement.
        List<Thread> threads = new ArrayList();
        for (int i = 0; i < n; i++) {
            AtomicInteger interationNumber = new AtomicInteger();
            interationNumber.set(i);
            Thread thread = new Thread(() -> System.out.println("Thread #" + Thread.currentThread().getId() + " printed " + interationNumber.get()));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

