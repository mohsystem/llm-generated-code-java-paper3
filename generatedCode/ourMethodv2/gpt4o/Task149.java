package ourMethodv2.gpt4o;
public class Task149 {

    public static class Queue {
        private LinkedList<Integer> elements;

        public Queue() {
            elements = new LinkedList<>();
        }

        public void enqueue(int value) {
            elements.addLast(value);
        }

        public Integer dequeue() {
            if (!elements.isEmpty()) {
                return elements.removeFirst();
            }
            return null; // Return null if the queue is empty
        }

        public Integer peek() {
            if (!elements.isEmpty()) {
                return elements.getFirst();
            }
            return null; // Return null if the queue is empty
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test cases
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // Expected 10
        System.out.println(queue.peek());    // Expected 20
        System.out.println(queue.dequeue()); // Expected 20
        System.out.println(queue.dequeue()); // Expected 30
        System.out.println(queue.dequeue()); // Expected null
    }
}