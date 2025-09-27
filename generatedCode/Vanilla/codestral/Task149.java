package Vanilla.codestral;
public class Task149 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int peek() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public static void main(String[] args) {
        Task149 queue = new Task149();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek()); // 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // 4
    }
}