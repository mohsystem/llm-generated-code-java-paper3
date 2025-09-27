package CoT.gpt4o;
public class Task148 {
    private static class Stack {
        private int[] elements;
        private int top;
        private int capacity;

        public Stack(int size) {
            elements = new int[size];
            capacity = size;
            top = -1;
        }

        public boolean push(int item) {
            if (top >= capacity - 1) {
                return false; // Stack Overflow
            }
            elements[++top] = item;
            return true;
        }

        public Integer pop() {
            if (top < 0) {
                return null; // Stack Underflow
            }
            return elements[top--];
        }

        public Integer peek() {
            if (top < 0) {
                return null; // Stack is empty
            }
            return elements[top];
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println(stack.push(1)); // true
        System.out.println(stack.push(2)); // true
        System.out.println(stack.push(3)); // true
        System.out.println(stack.push(4)); // true
        System.out.println(stack.push(5)); // true
        System.out.println(stack.push(6)); // false (Overflow)

        System.out.println(stack.peek()); // 5

        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 4
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // null (Underflow)
    }
}