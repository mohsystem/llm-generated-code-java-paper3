package Vanilla.openai;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task198 {
    private static Random random = new Random();

    public static int rand7() {
        return random.nextInt(7) + 1;
    }

    public static int rand10() {
        int result;
        do {
            int row = rand7();
            int col = rand7();
            int idx = (row - 1) * 7 + col;
            if (idx <= 40) {
                result = 1 + (idx - 1) % 10;
                break;
            }
        } while (true);
        return result;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 5};
        for (int n : testCases) {
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                results.add(rand10());
            }
            System.out.println("Output for n = " + n + ": " + results);
        }
    }
}