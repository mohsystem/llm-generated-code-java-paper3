package Vanilla.gemini;
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
        System.out.println(stack.peek()); // Output: 30
        System.out.println(stack.pop()); // Output: 30
        System.out.println(stack.pop()); // Output: 20
        System.out.println(stack.isEmpty()); // Output: false
        stack.pop();
        System.out.println(stack.isEmpty()); // Output: true


        Task148 stack2 = new Task148();
        System.out.println(stack2.isEmpty()); //true
        stack2.push(1);
        System.out.println(stack2.peek()); // 1
        stack2.push(2);
        System.out.println(stack2.peek()); // 2
        stack2.push(3);
        System.out.println(stack2.peek()); // 3
        System.out.println(stack2.pop()); // 3
        System.out.println(stack2.pop()); // 2
        System.out.println(stack2.pop()); // 1
        System.out.println(stack2.isEmpty()); //true

        Task148 stack3 = new Task148();
        try {
             stack3.pop();
        } catch (RuntimeException e) {
             System.out.println(e.getMessage()); // Stack is empty
        }

        Task148 stack4 = new Task148();
        stack4.push(5);
        System.out.println(stack4.peek()); // 5
        stack4.push(6);
        System.out.println(stack4.peek()); // 6
        stack4.pop();
        System.out.println(stack4.peek()); // 5

        Task148 stack5 = new Task148();
        stack5.push(100);
        stack5.push(200);
        stack5.pop();
        stack5.push(300);
        System.out.println(stack5.peek()); //300
        System.out.println(stack5.pop()); //300
        System.out.println(stack5.pop()); //100


    }
}