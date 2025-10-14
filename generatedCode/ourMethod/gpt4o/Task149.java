package ourMethod.openai;
public class Task149 {
    private static class Queue {
        private int[] elements;
        private int front, rear, size, capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
            elements = new int[capacity];
            front = this.size = 0;
            rear = capacity - 1;
        }

        boolean isFull() {
            return size == capacity;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % capacity;
            elements[rear] = item;
            size = size + 1;
        }

        int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            int item = elements[front];
            front = (front + 1) % capacity;
            size = size - 1;
            return item;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return elements[front];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        // Test cases
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.enqueue(60);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}