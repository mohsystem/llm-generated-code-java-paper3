package CoT.llama31;
public class Task149 {
    private int[] items;
    private int front, rear, size;

    public Task149(int capacity) {
        items = new int[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        items[rear] = element;
        rear = (rear + 1) % items.length;
        size++;
        System.out.println("Inserted " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int element = items[front];
        front = (front + 1) % items.length;
        size--;
        System.out.println(element + " Deleted");
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        int temp = front;
        for (int i = 0; i < size; i++) {
            System.out.print(items[temp] + " ");
            temp = (temp + 1) % items.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task149 queue = new Task149(5);
        queue.dequeue(); // Queue is empty
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // Queue is full
        queue.display(); // 1 2 3 4 5
        System.out.println("Peek: " + queue.peek()); // Peek: 1
        queue.dequeue();
        queue.display(); // 2 3 4 5
    }
}