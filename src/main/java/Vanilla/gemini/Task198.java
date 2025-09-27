package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Task198 {

    private static final Random rand = new Random();

    public static int rand7() {
        return rand.nextInt(7) + 1;
    }

    public static int rand10() {
        int val = (rand7() - 1) * 7 + rand7();
        while (val > 40) {
            val = (rand7() - 1) * 7 + rand7();
        }
        return (val - 1) % 10 + 1;
    }

    public static void main(String[] args) {
        System.out.println(rand10List(1)); // Example 1
        System.out.println(rand10List(2)); // Example 2
        System.out.println(rand10List(3)); // Example 3
        System.out.println(rand10List(5)); // Test case 4
        System.out.println(rand10List(10)); // Test case 5
    }


    public static List<Integer> rand10List(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(rand10());
        }
        return result;
    }
}