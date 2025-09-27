package CoT.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Task198 {
    private Random rand = new Random();

    public int rand7() {
        return rand.nextInt(7) + 1;
    }

    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }

    public static void main(String[] args) {
        Task198 task = new Task198();

        int n1 = 1;
        List<Integer> result1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            result1.add(task.rand10());
        }
        System.out.println(result1); // Expected: [A random number between 1 and 10]

        int n2 = 2;
        List<Integer> result2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            result2.add(task.rand10());
        }
        System.out.println(result2); // Expected: [Two random numbers between 1 and 10]

        int n3 = 3;
        List<Integer> result3 = new ArrayList<>();
        for (int i = 0; i < n3; i++) {
            result3.add(task.rand10());
        }
        System.out.println(result3); // Expected: [Three random numbers between 1 and 10]


        int n4 = 5;
        List<Integer> result4 = new ArrayList<>();
        for (int i = 0; i < n4; i++) {
            result4.add(task.rand10());
        }
        System.out.println(result4);


        int n5 = 10;
        List<Integer> result5 = new ArrayList<>();
        for (int i = 0; i < n5; i++) {
            result5.add(task.rand10());
        }
        System.out.println(result5);
    }
}