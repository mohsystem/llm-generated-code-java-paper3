package ZeroShot.gpt4o;
public class Task148 {
    static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public Stack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1;
        }

        public boolean push(int value) {
            if (isFull()) {
                return false;
            }
            stackArray[++top] = value;
            return true;
        }

        public Integer pop() {
            if (isEmpty()) {
                return null;
            }
            return stackArray[top--];
        }

        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return stackArray[top];
        }

        public boolean isFull() {
            return top == maxSize - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println(stack.push(10)); // true
        System.out.println(stack.push(20)); // true
        System.out.println(stack.push(30)); // true
        System.out.println(stack.peek());   // 30
        System.out.println(stack.pop());    // 30
        System.out.println(stack.pop());    // 20
        System.out.println(stack.pop());    // 10
        System.out.println(stack.pop());    // null
    }
}