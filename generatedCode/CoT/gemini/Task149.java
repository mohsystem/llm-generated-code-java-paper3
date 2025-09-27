package CoT.gemini;
import java.util.LinkedList;
import java.util.Queue;

public class Task149 {

    public static class MyQueue<T> {
        private Queue<T> queue;

        public MyQueue() {
            queue = new LinkedList<>();
        }

        public void enqueue(T item) {
            queue.offer(item);
        }

        public T dequeue() {
            if (isEmpty()) {
                return null;
            }
            return queue.poll();
        }

        public T peek() {
            if (isEmpty()) {
                return null;
            }
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        // Test cases
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.isEmpty()); // Output: true

        MyQueue<String> stringQueue = new MyQueue<>();
        stringQueue.enqueue("apple");
        stringQueue.enqueue("banana");
        System.out.println(stringQueue.dequeue()); // Output: apple

    }
}