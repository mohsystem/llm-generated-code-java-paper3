package CoT.codestral;
import java.util.Random;

public class Task198 {
    private static final Random random = new Random();

    public static int rand7() {
        return random.nextInt(7) + 1;
    }

    public static int rand10() {
        int num;
        do {
            num = (rand7() - 1) * 7 + rand7();
        } while (num > 40);
        return num % 10 + 1;
    }

    public static void main(String[] args) {
        System.out.println(rand10()); // Test case 1
        System.out.println(rand10()); // Test case 2
        System.out.println(rand10()); // Test case 3
    }
}