package ZeroShot.gemini;
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
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // Output: 3
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.pop());  // Output: 2

        Task148 stack2 = new Task148();
        System.out.println(stack2.isEmpty()); // Output: true
        stack2.push(10);
        System.out.println(stack2.isEmpty()); // Output: false
        System.out.println(stack2.pop()); // Output: 10

        Task148 stack3 = new Task148();
        stack3.push(5);
        stack3.push(6);
        System.out.println(stack3.peek()); // Output 6
        System.out.println(stack3.peek()); // Output 6


        Task148 stack4 = new Task148();
        try {
            stack4.pop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Output: Stack is empty
        }

        Task148 stack5 = new Task148();
        try {
            stack5.peek();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Output: Stack is empty
        }
    }
}