package ZeroShot.gemini;
import java.util.LinkedList;
import java.util.Queue;

class Task149 {
    public static class MyQueue<T> {
        private final Queue<T> queue;

        public MyQueue() {
            queue = new LinkedList<>();
        }

        public void enqueue(T item) {
            queue.offer(item);
        }

        public T dequeue() {
            return queue.poll();
        }

        public T peek() {
            return queue.peek();
        }
         public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        // Test case 1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());    // Output: 2

        // Test case 2
        MyQueue<String> stringQueue = new MyQueue<>();
        stringQueue.enqueue("apple");
        stringQueue.enqueue("banana");
        System.out.println(stringQueue.dequeue()); // Output: apple
        System.out.println(stringQueue.dequeue()); // Output: banana

        // Test case 3 - Empty queue
        MyQueue<Double> emptyQueue = new MyQueue<>();
        System.out.println(emptyQueue.dequeue() == null ? "null" : emptyQueue.dequeue()); // Output: null
        

        // Test case 4 - Peek on empty queue
        MyQueue<Character> emptyQueue2 = new MyQueue<>();
        System.out.println(emptyQueue2.peek() == null ? "null" : emptyQueue2.peek()); // Output: null
        
        // Test case 5 - Mixed data types
        MyQueue<Object> mixedQueue = new MyQueue<>();
        mixedQueue.enqueue(10);
        mixedQueue.enqueue("hello");
        mixedQueue.enqueue(3.14);
        System.out.println(mixedQueue.dequeue()); // Output: 10
        System.out.println(mixedQueue.dequeue()); // Output: hello


    }
}