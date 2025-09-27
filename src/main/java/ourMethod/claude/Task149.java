package ourMethod.claude;

public class Task149 {
    private static class Queue {
        private int[] array;
        private int front;
        private int rear;
        private int size;
        private final int capacity;
        
        public Queue(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive");
            }
            this.capacity = capacity;
            this.array = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        public void enqueue(int value) {
            if (size >= capacity) {
                throw new IllegalStateException("Queue is full");
            }
            rear = (rear + 1) % capacity;
            array[rear] = value;
            size++;
        }
        
        public int dequeue() {
            if (size <= 0) {
                throw new IllegalStateException("Queue is empty");
            }
            int value = array[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }
        
        public int peek() {
            if (size <= 0) {
                throw new IllegalStateException("Queue is empty");
            }
            return array[front];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        // Test case 1: Basic operations
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        System.out.println("Peek: " + q.peek()); // Should print 1
        System.out.println("Dequeue: " + q.dequeue()); // Should print 1
        
        // Test case 2: Empty queue
        Queue q2 = new Queue(3);
        try {
            q2.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
        
        // Test case 3: Full queue
        Queue q3 = new Queue(2);
        q3.enqueue(1);
        q3.enqueue(2);
        try {
            q3.enqueue(3);
        } catch (IllegalStateException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
        
        // Test case 4: Circular behavior
        Queue q4 = new Queue(3);
        q4.enqueue(1);
        q4.enqueue(2);
        q4.enqueue(3);
        q4.dequeue();
        q4.dequeue();
        q4.enqueue(4);
        System.out.println("Peek after circular: " + q4.peek()); // Should print 3
        
        // Test case 5: Invalid capacity
        try {
            Queue q5 = new Queue(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
    }
}
