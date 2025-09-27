package ourMethod.codestral;
import java.security.SecureRandom;

public class Task128 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt());
        }
    }
}