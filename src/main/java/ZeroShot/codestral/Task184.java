package ZeroShot.codestral;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final Random RANDOM = new Random();
    private static final Set<String> existingNames = new HashSet<>();

    public static String generateName() {
        String name;
        do {
            name = UPPER.charAt(RANDOM.nextInt(UPPER.length())) + "" +
                   UPPER.charAt(RANDOM.nextInt(UPPER.length())) + "" +
                   DIGITS.charAt(RANDOM.nextInt(DIGITS.length())) + "" +
                   DIGITS.charAt(RANDOM.nextInt(DIGITS.length())) + "" +
                   DIGITS.charAt(RANDOM.nextInt(DIGITS.length()));
        } while (existingNames.contains(name));
        existingNames.add(name);
        return name;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateName());
        }
    }
}