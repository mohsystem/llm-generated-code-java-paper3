package CoT.claude;

public class Task149 {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int MAX_SIZE = 100;

    public Task149() {
        queue = new int[MAX_SIZE];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (size >= MAX_SIZE) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        return element;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Task149 queue = new Task149();
        
        // Test case 1: Basic enqueue and dequeue
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue()); // Should print 1
        
        // Test case 2: Peek operation
        queue.enqueue(3);
        System.out.println(queue.peek()); // Should print 2
        
        // Test case 3: Multiple operations
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Should print 2
        System.out.println(queue.dequeue()); // Should print 3
        
        // Test case 4: Empty queue check
        System.out.println(queue.isEmpty()); // Should print false
        queue.dequeue();
        System.out.println(queue.isEmpty()); // Should print true
        
        // Test case 5: Exception handling
        try {
            queue.dequeue(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
