package Vanilla.llama31;
public class Task149 {
    static class Queue {
        int[] arr;
        int front, rear, size;

        public Queue(int capacity) {
            arr = new int[capacity];
            front = rear = size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % arr.length;
            }
            arr[rear] = data;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            if (size == 1) {
                front = rear = 0;
            } else {
                front = (front + 1) % arr.length;
            }
            size--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            int temp = front;
            for (int i = 0; i < size; i++) {
                System.out.print(arr[temp] + " ");
                temp = (temp + 1) % arr.length;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display(); // Output: 1 2 3 4 5
        System.out.println("Peek: " + q.peek()); // Output: Peek: 1
        System.out.println("Dequeue: " + q.dequeue()); // Output: Dequeue: 1
        q.display(); // Output: 2 3 4 5
    }
}