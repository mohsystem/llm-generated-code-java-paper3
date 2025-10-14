package ZeroShot.openai;
import java.util.LinkedList;
import java.util.Queue;

public class Task149 {

    private Queue<Integer> queue = new LinkedList<>();

    public void enqueue(int value) {
        queue.offer(value);
    }

    public Integer dequeue() {
        return queue.poll();
    }

    public Integer peek() {
        return queue.peek();
    }

    public static void main(String[] args) {
        Task149 queue = new Task149();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // null
    }
}