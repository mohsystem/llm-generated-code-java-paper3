package ZeroShot.llama31;
public class Task149 {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Task149(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = queue[front];
        if (size == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[front];
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Task149 queue = new Task149(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 1
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 2
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 2
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 3
    }
}