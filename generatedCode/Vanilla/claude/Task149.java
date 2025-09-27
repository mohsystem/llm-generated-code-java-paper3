package Vanilla.claude;

class Task149 {
    private static class Queue {
        private int[] arr;
        private int front, rear, size;
        private static final int MAX_SIZE = 100;

        public Queue() {
            arr = new int[MAX_SIZE];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int data) {
            if (size == MAX_SIZE) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % MAX_SIZE;
            arr[rear] = data;
            size++;
        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            front = (front + 1) % MAX_SIZE;
            size--;
            return data;
        }

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        
        // Test case 1: Basic enqueue and dequeue
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue()); // Should print 1
        
        // Test case 2: Peek operation
        queue.enqueue(3);
        System.out.println(queue.peek()); // Should print 2
        
        // Test case 3: Multiple operations
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue()); // Should print 2
        System.out.println(queue.dequeue()); // Should print 3
        
        // Test case 4: Empty queue operations
        Queue emptyQueue = new Queue();
        System.out.println(emptyQueue.dequeue()); // Should print "Queue is empty" and -1
        
        // Test case 5: Circular array behavior
        Queue q = new Queue();
        for(int i = 1; i <= 5; i++) {
            q.enqueue(i);
            q.dequeue();
        }
        q.enqueue(10);
        System.out.println(q.peek()); // Should print 10
    }
}
