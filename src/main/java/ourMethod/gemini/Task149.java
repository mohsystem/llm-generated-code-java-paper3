package ourMethod.gemini;
import java.util.LinkedList;
import java.util.Queue;

public class Task149 {

    public static class MyQueue<T> {
        private Queue<T> queue;

        public MyQueue() {
            queue = new LinkedList<>();
        }

        public void enqueue(T item) {
            queue.offer(item);
        }

        public T dequeue() {
            if (queue.isEmpty()) {
                return null; // Or throw an exception
            }
            return queue.poll();
        }

        public T peek() {
            if (queue.isEmpty()) {
                return null; // Or throw an exception
            }
            return queue.peek();
        }


        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);

        System.out.println("Peek :"+ queue1.peek());
        System.out.println("Dequeue :"+ queue1.dequeue());
        System.out.println("Peek :"+ queue1.peek());



        MyQueue<String> queue2 = new MyQueue<>();

        queue2.enqueue("apple");
        queue2.enqueue("banana");
        queue2.enqueue("cherry");

        System.out.println("Peek :"+ queue2.peek());
        System.out.println("Dequeue :"+ queue2.dequeue());
        System.out.println("Peek :"+ queue2.peek());



        MyQueue<Double> queue3 = new MyQueue<>();
        queue3.enqueue(10.5);
        queue3.enqueue(20.3);
        queue3.enqueue(30.1);

        System.out.println("Peek :"+ queue3.peek());
        System.out.println("Dequeue :"+ queue3.dequeue());
        System.out.println("Peek :"+ queue3.peek());




        MyQueue<Integer> queue4 = new MyQueue<>();
        System.out.println("Is queue4 Empty? "+ queue4.isEmpty());
        queue4.enqueue(1);
        queue4.enqueue(2);

        System.out.println("Is queue4 Empty? "+ queue4.isEmpty());
        System.out.println("Dequeue :"+ queue4.dequeue());

        System.out.println("Is queue4 Empty? "+ queue4.isEmpty());
        System.out.println("Dequeue :"+ queue4.dequeue());
        System.out.println("Is queue4 Empty? "+ queue4.isEmpty());

        System.out.println("Dequeue :"+ queue4.dequeue());




        MyQueue<Character> queue5 = new MyQueue<>();
        queue5.enqueue('a');
        queue5.enqueue('b');
        queue5.enqueue('c');
        System.out.println("Peek :"+ queue5.peek());
        System.out.println("Dequeue :"+ queue5.dequeue());
        System.out.println("Peek :"+ queue5.peek());


    }
}