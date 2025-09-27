package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Task198 {
    private Random rand = new Random();

    public int rand7() {
        return rand.nextInt(7) + 1;
    }

    public int rand10() {
        int val = (rand7() - 1) * 7 + rand7();
        if (val > 40) {
            return rand10();
        }
        return (val - 1) % 10 + 1;
    }

    public static void main(String[] args) {
        Task198 task = new Task198();
        int[] testCases = {1, 2, 3, 5, 10};
        for (int n : testCases) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(task.rand10());
            }
            System.out.println(result);
        }
    }
}