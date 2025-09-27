package ZeroShot.codestral;
public class Task149 {
    static class Queue {
        static final int MAX = 1000;
        int[] arr = new int[MAX];
        int front, rear;

        Queue() {
            front = -1;
            rear = -1;
        }

        static boolean isFull(Queue queue) {
            return (queue.rear == MAX - 1);
        }

        static boolean isEmpty(Queue queue) {
            return (queue.front == -1);
        }

        static void enqueue(Queue queue, int item) {
            if (isFull(queue))
                return;

            if (queue.front == -1)
                queue.front = 0;

            queue.arr[++queue.rear] = item;
        }

        static int dequeue(Queue queue) {
            if (isEmpty(queue))
                return Integer.MIN_VALUE;

            int item = queue.arr[queue.front];

            if (queue.front >= queue.rear) {
                queue.front = -1;
                queue.rear = -1;
            } else {
                queue.front++;
            }

            return item;
        }

        static int peek(Queue queue) {
            if (isEmpty(queue))
                return Integer.MIN_VALUE;

            return queue.arr[queue.front];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        enqueue(queue, 1);
        enqueue(queue, 2);
        enqueue(queue, 3);

        System.out.println(dequeue(queue));
        System.out.println(peek(queue));
        enqueue(queue, 4);
        System.out.println(dequeue(queue));
        System.out.println(dequeue(queue));
        System.out.println(dequeue(queue));
    }
}