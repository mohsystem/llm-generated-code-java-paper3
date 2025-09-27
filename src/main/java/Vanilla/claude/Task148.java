package Vanilla.claude;

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return -1;
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        }
        return -1;
    }
}

public class Task148 {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        // Test case 1: Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Peek after pushing 3 elements: " + stack.peek());  // Should print 3
        
        // Test case 2: Pop element
        System.out.println("Popped element: " + stack.pop());  // Should print 3
        
        // Test case 3: Peek after pop
        System.out.println("Peek after pop: " + stack.peek());  // Should print 2
        
        // Test case 4: Pop until empty
        System.out.println("Pop: " + stack.pop());  // Should print 2
        System.out.println("Pop: " + stack.pop());  // Should print 1
        System.out.println("Pop empty stack: " + stack.pop());  // Should print -1
        
        // Test case 5: Push after empty
        stack.push(5);
        System.out.println("Peek after pushing to empty stack: " + stack.peek());  // Should print 5
    }
}
