package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task148 {

    private List<Integer> stack;

    public Task148() {
        stack = new ArrayList<>();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Task148 stack = new Task148();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());  // Output: 30
        System.out.println(stack.peek());  // Output: 20
        stack.push(40);
        System.out.println(stack.pop());  // Output: 40
        System.out.println(stack.isEmpty()); // Output: false
        System.out.println(stack.pop()); // Output: 20
        System.out.println(stack.pop()); // Output: 10
        System.out.println(stack.isEmpty()); // Output: true


    }
}