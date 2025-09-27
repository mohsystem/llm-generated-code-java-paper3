package Vanilla.llama31;
import java.util.Random;

public class Task198 {
    public int rand10() {
        while (true) {
            int i = rand7() - 1;
            int j = rand7();
            int value = i * 7 + j;
            if (value <= 40) {
                return value % 10 + 1;
            }
        }
    }

    public int rand7() {
        // This is a placeholder for the actual rand7() API
        // You should replace this with the actual implementation
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }

    public static void main(String[] args) {
        Task198 task = new Task198();
        int n = 5; // Number of test cases
        for (int i = 0; i < n; i++) {
            System.out.print(task.rand10() + " ");
        }
    }
}