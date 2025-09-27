package ourMethod.gemini;
import java.util.List;

class Task9 {
    public String oddOrEven(List<Integer> array) {
        int sum = 0;
        if (array == null || array.isEmpty()) {
            return "even";
        }
        for (int num : array) {
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        Task9 task9 = new Task9();

        List<Integer> test1 = List.of(0);
        System.out.println("Test 1: " + task9.oddOrEven(test1)); // Output: even

        List<Integer> test2 = List.of(0, 1, 4);
        System.out.println("Test 2: " + task9.oddOrEven(test2)); // Output: odd

        List<Integer> test3 = List.of(0, -1, -5);
        System.out.println("Test 3: " + task9.oddOrEven(test3)); // Output: even
        
        List<Integer> test4 = List.of();
        System.out.println("Test 4: " + task9.oddOrEven(test4)); // Output: even

        List<Integer> test5 = List.of(1, 2, 3, 4, 5);
        System.out.println("Test 5: " + task9.oddOrEven(test5)); // Output: odd
    }
}