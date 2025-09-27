package CoT.codestral;
class Task149 {
    static class Queue {
        static final int MAX = 1000;
        int front, rear, size;
        int array[] = new int[MAX];

        Queue() {
            front = rear = size = 0;
        }

        void enqueue(int item) {
            if (size == MAX) {
                System.out.println("Queue is full");
                return;
            }
            array[rear] = item;
            rear = (rear + 1) % MAX;
            size++;
        }

        int dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            int item = array[front];
            front = (front + 1) % MAX;
            size--;
            return item;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return array[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("Dequeued item: " + q.dequeue());
        System.out.println("Front item: " + q.peek());
    }
}