package ZeroShot.claude;

public class Task148 {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Task148(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            throw new RuntimeException("Stack is full");
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        Task148 stack = new Task148(5);
        
        // Test case 1: Push elements
        stack.push(10);
        stack.push(20);
        System.out.println("Peek after pushing 10, 20: " + stack.peek()); // Should print 20

        // Test case 2: Pop element
        System.out.println("Popped: " + stack.pop()); // Should print 20
        System.out.println("Peek after pop: " + stack.peek()); // Should print 10

        // Test case 3: Push more elements
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Test case 4: Pop until empty
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Test case 5: Test exception handling
        try {
            stack.pop(); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
