package Vanilla.codestral;
class Task148 {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Task148(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        Task148 theStack = new Task148(5);
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        System.out.println(theStack.pop());
        System.out.println(theStack.peek());
    }
}