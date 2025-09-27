package Vanilla.llama31;
public class Task148 {
    private int[] stack;
    private int top;
    private int maxSize;

    public Task148(int size) {
        stack = new int[size];
        top = -1;
        maxSize = size;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Task148 stack = new Task148(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek()); // Output: 30
        System.out.println("Pop: " + stack.pop());  // Output: 30
        System.out.println("Peek: " + stack.peek()); // Output: 20
        System.out.println("Pop: " + stack.pop());  // Output: 20
        System.out.println("Pop: " + stack.pop());  // Output: 10
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: true
    }
}