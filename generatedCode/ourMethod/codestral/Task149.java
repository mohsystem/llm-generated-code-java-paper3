package ourMethod.codestral;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Task149 {
    private LinkedList<Integer> queue;

    public Task149() {
        queue = new LinkedList<>();
    }

    public void enqueue(int data) {
        queue.addLast(data);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.getFirst();
    }

    public static void main(String[] args) {
        Task149 queue = new Task149();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.peek());  // Output: 1
        System.out.println(queue.dequeue());  // Output: 1
        System.out.println(queue.peek());  // Output: 2
    }
}