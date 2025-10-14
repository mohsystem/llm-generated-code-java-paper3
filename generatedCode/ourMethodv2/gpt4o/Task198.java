package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task198 {
    public static int rand7() {
        return 1 + (int) (Math.random() * 7);
    }

    public static int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7(); // Uniformly distributed in [1,49]
            if (num <= 40) return 1 + (num - 1) % 10;
        }
    }

    public static List<Integer> testRand10(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            results.add(rand10());
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(testRand10(1)); // Example 1
        System.out.println(testRand10(2)); // Example 2
        System.out.println(testRand10(3)); // Example 3
        System.out.println(testRand10(5)); // Additional test case
        System.out.println(testRand10(10)); // Additional test case
    }
}