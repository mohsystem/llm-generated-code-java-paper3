package CoT.claude;

public class Task148 {
    private int maxSize;
    private int[] stackArray;
    private int top;
    
    public Task148(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be positive");
        }
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int value) {
        if (top >= maxSize - 1) {
            throw new IllegalStateException("Stack overflow");
        }
        stackArray[++top] = value;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
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
    
    public static void main(String[] args) {
        // Test case 1: Basic push and pop
        Task148 stack1 = new Task148(5);
        stack1.push(1);
        stack1.push(2);
        System.out.println("Test 1: " + (stack1.pop() == 2));
        
        // Test case 2: Peek operation
        Task148 stack2 = new Task148(3);
        stack2.push(10);
        System.out.println("Test 2: " + (stack2.peek() == 10));
        
        // Test case 3: Empty stack check
        Task148 stack3 = new Task148(2);
        System.out.println("Test 3: " + stack3.isEmpty());
        
        // Test case 4: Full stack check
        Task148 stack4 = new Task148(2);
        stack4.push(1);
        stack4.push(2);
        System.out.println("Test 4: " + stack4.isFull());
        
        // Test case 5: Exception handling
        Task148 stack5 = new Task148(1);
        try {
            stack5.pop();
            System.out.println("Test 5: Failed");
        } catch (IllegalStateException e) {
            System.out.println("Test 5: Passed");
        }
    }
}
