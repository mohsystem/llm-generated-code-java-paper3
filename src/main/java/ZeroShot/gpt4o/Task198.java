package ZeroShot.gpt4o;
import java.util.*;

public class Task198 {

    public static void main(String[] args) {
        Task198 task = new Task198();
        System.out.println(task.testRand10(1));
        System.out.println(task.testRand10(2));
        System.out.println(task.testRand10(3));
        System.out.println(task.testRand10(4));
        System.out.println(task.testRand10(5));
    }
    
    private static int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public int rand10() {
        int num;
        do {
            int row = rand7();
            int col = rand7();
            num = (row - 1) * 7 + col;
        } while (num > 40);
        return 1 + (num - 1) % 10;
    }
    
    public List<Integer> testRand10(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            results.add(rand10());
        }
        return results;
    }
}