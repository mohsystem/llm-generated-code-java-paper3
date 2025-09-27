package CoT.gpt4o;
import java.util.LinkedList;
import java.util.Queue;

public class Task149 {

    static class SecureQueue<T> {
        private Queue<T> queue;

        public SecureQueue() {
            this.queue = new LinkedList<>();
        }

        public synchronized void enqueue(T item) {
            queue.add(item);
        }

        public synchronized T dequeue() {
            if (queue.isEmpty()) {
                return null;
            }
            return queue.poll();
        }

        public synchronized T peek() {
            if (queue.isEmpty()) {
                return null;
            }
            return queue.peek();
        }

        public synchronized boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        SecureQueue<Integer> queue = new SecureQueue<>();
        
        // Test case 1
        queue.enqueue(10);
        System.out.println(queue.peek()); // Output: 10

        // Test case 2
        queue.enqueue(20);
        System.out.println(queue.dequeue()); // Output: 10

        // Test case 3
        System.out.println(queue.peek()); // Output: 20

        // Test case 4
        System.out.println(queue.dequeue()); // Output: 20

        // Test case 5
        System.out.println(queue.isEmpty()); // Output: true
    }
}