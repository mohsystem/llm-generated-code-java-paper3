package CoT.llama31;
public class Task148 {
    private int[] arr;
    private int top;
    private int capacity;

    public Task148(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(1);
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
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