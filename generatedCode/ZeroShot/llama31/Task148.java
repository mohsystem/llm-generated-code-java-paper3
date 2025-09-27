package ZeroShot.llama31;
public class Task148 {
    private int[] stack;
    private int top;
    private int capacity;

    public Task148(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return stack[top];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Task148 stack = new Task148(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Popped item: " + stack.pop());
        System.out.println("Peek item: " + stack.peek());
        stack.push(4);
        stack.push(5);
        System.out.println("Popped item: " + stack.pop());
        System.out.println("Peek item: " + stack.peek());
    }
}