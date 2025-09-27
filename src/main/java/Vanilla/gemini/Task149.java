package Vanilla.gemini;
import java.util.LinkedList;
import java.util.Queue;

class Task149 {

    private Queue<Integer> queue;

    public Task149() {
        queue = new LinkedList<>();
    }

    public void enqueue(int value) {
        queue.offer(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.poll();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Task149 queue = new Task149();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue()); // Output: 10
        System.out.println(queue.peek());   // Output: 20
        queue.dequeue();
        queue.enqueue(40);
        System.out.println(queue.dequeue()); // Output: 30
        System.out.println(queue.dequeue()); // Output: 40
        System.out.println(queue.isEmpty()); // Output: true

    }
}