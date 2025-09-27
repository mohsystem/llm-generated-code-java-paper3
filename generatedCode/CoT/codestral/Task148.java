package CoT.codestral;
class Task148 {
    private static class Stack {
        private int maxSize;
        private int top;
        private int[] stackArray;

        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int value) {
            if (top < maxSize - 1) {
                stackArray[++top] = value;
            } else {
                System.out.println("Stack is full. Cannot push " + value);
            }
        }

        public int pop() {
            if (top >= 0) {
                return stackArray[top--];
            } else {
                System.out.println("Stack is empty. Cannot pop.");
                return -1;
            }
        }

        public int peek() {
            if (top >= 0) {
                return stackArray[top];
            } else {
                System.out.println("Stack is empty. Cannot peek.");
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // Output: 3
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.peek()); // Output: 2
    }
}