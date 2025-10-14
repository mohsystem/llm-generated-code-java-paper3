package Vanilla.openai;
public class Task149 {
    private static class Queue {
        private LinkedList<Integer> list = new LinkedList<>();

        public void enqueue(int item) {
            list.addLast(item);
        }

        public int dequeue() {
            if (list.isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return list.removeFirst();
        }

        public int peek() {
            if (list.isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return list.getFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        queue.enqueue(40);
        System.out.println(queue.dequeue()); // 20
    }
}