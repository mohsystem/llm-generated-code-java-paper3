package CoT.gemini;
import java.util.ArrayList;
import java.util.List;

class Task148 {

    private static class Stack<T> {
        private final List<T> list;

        public Stack() {
            list = new ArrayList<>();
        }

        public void push(T item) {
            list.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return list.remove(list.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // Output: 3
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
        System.out.println(stack.pop()); // Output: 1
        System.out.println(stack.isEmpty()); // Output: true


        Stack<String> stringStack = new Stack<>();
        stringStack.push("apple");
        stringStack.push("banana");
        System.out.println(stringStack.peek());  // Output: banana
        stringStack.push("cherry");
        System.out.println(stringStack.pop());  // Output: cherry
        System.out.println(stringStack.pop());  // Output: banana
        System.out.println(stringStack.pop());  // Output: apple
        //System.out.println(stringStack.pop());  // Throws IllegalStateException: Stack is empty



    }
}