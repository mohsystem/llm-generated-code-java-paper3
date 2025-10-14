package ourMethod.openai;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Task148 {
    private ArrayList<Integer> stackList;

    public Task148() {
        stackList = new ArrayList<>();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    public int peek() {
        if (stackList.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public static void main(String[] args) {
        Task148 stack = new Task148();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop()); // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.pop()); // 20
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.pop()); // 10
    }
}