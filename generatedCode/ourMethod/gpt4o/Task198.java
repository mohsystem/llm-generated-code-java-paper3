package ourMethod.openai;
import java.util.Random;

public class Task198 {
    private static Random random = new Random();

    private static int rand7() {
        return random.nextInt(7) + 1;
    }

    private static int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7(); // Generate a number from 1 to 49
            if (num <= 40) { // Use numbers 1 to 40 to map to 1 to 10
                return (num - 1) % 10 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 1, n2 = 2, n3 = 3, n4 = 4, n5 = 5;
        for (int i = 0; i < n1; i++) {
            System.out.println(rand10());
        }
        for (int i = 0; i < n2; i++) {
            System.out.println(rand10());
        }
        for (int i = 0; i < n3; i++) {
            System.out.println(rand10());
        }
        for (int i = 0; i < n4; i++) {
            System.out.println(rand10());
        }
        for (int i = 0; i < n5; i++) {
            System.out.println(rand10());
        }
    }
}