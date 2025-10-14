package ourMethodv2.gpt4o;
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

        public void push(int value) {
            if (top < maxSize - 1) {
                stackArray[++top] = value;
            } else {
                System.out.println("Stack is full");
            }
        }

        public int pop() {
            if (top >= 0) {
                return stackArray[top--];
            } else {
                System.out.println("Stack is empty");
                return -1; // Assuming negative values aren't valid stack values
            }
        }

        public int peek() {
            if (top >= 0) {
                return stackArray[top];
            } else {
                System.out.println("Stack is empty");
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek()); // Expected: 30
        System.out.println(stack.pop());  // Expected: 30
        System.out.println(stack.pop());  // Expected: 20
        stack.push(40);
        System.out.println(stack.pop());  // Expected: 40
        System.out.println(stack.pop());  // Expected: 10
        System.out.println(stack.pop());  // Expected: Stack is empty
    }
}