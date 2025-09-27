package ourMethod.llama31;
public class Task149 {
    private int[] queue;
    private int front, rear, size;

    public Task149(int capacity) {
        queue = new int[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        size++;
        System.out.println("Inserted " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println(element + " Deleted");
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % queue.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task149 q = new Task149(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();
        q.dequeue();
        q.display();
        System.out.println("Peek: " + q.peek());
    }
}