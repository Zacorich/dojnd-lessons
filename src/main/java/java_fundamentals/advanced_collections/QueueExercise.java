package java_fundamentals.advanced_collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExercise {
    public static void queueExercise(){
        //queues add elements to the END of the queue and pop elements from the TOP of the queue.
        //when for example stacks add element tot the END of the stack and pop elements from the END of the stack.

        Queue<String> queuedCustomers = new LinkedList<>();
        Collections.addAll(queuedCustomers, "1234", "3412", "0123", "4321");

        //pop objects from the top of the queue in a loop
        System.out.println("Queue size: " + queuedCustomers.size());
        while(!queuedCustomers.isEmpty()){
            System.out.println("Customer " + queuedCustomers.poll() + " is getting helped");
            System.out.println("Queue size: " + queuedCustomers.size());
        }
    }
}
