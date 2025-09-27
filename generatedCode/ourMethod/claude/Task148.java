package ourMethod.claude;

public class Task148 {
    private static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;
        
        public Stack(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Stack size must be positive");
            }
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1;
        }
        
        public void push(int value) {
            if (isFull()) {
                throw new IllegalStateException("Stack is full");
            }
            stackArray[++top] = value;
        }
        
        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stackArray[top--];
        }
        
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stackArray[top];
        }
        
        public boolean isEmpty() {
            return (top == -1);
        }
        
        public boolean isFull() {
            return (top == maxSize - 1);
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Basic push and pop
            Stack stack = new Stack(5);
            stack.push(1);
            System.out.println("Test 1: " + (stack.pop() == 1));

            // Test case 2: Multiple operations
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Test 2: " + (stack.peek() == 3 && stack.pop() == 3));

            // Test case 3: Empty stack
            stack.pop();
            stack.pop();
            System.out.println("Test 3: " + stack.isEmpty());

            // Test case 4: Full stack
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            System.out.println("Test 4: " + stack.isFull());

            // Test case 5: Exception handling
            try {
                stack.push(6); // Should throw exception
                System.out.println("Test 5: Failed");
            } catch (IllegalStateException e) {
                System.out.println("Test 5: Passed");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
