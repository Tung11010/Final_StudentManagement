import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Create a queue of Integer type
        Queue<Integer> queue = new LinkedList<>();
        
        // Add elements to the queue (enqueue)
        queue.add(10);
        queue.add(20);
        queue.add(30);
        
        System.out.println("Element at the front of the queue: " + queue.peek());
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Queue after removal: " + queue);
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

