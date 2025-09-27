package Vanilla.gpt4o;
public class Task148 {
    static class Stack {
        private int[] elements;
        private int top;
        private int capacity;

        public Stack(int size) {
            elements = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int value) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            elements[++top] = value;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return elements[top--];
        }

        public int peek() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return elements[top];
        }

        public static void main(String[] args) {
            Stack stack = new Stack(5);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);

            System.out.println(stack.pop()); // 5
            System.out.println(stack.peek()); // 4
            stack.push(6);
            System.out.println(stack.peek()); // 6
            System.out.println(stack.pop()); // 6
        }
    }
}