package Vanilla.codestral;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int NUMBER_OF_LETTERS = 2;

    private static final Set<String> existingNames = new HashSet<>();

    public static String generateName() {
        Random random = new Random();
        String name;
        do {
            name = "";
            for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
                name += UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length()));
            }
            for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
                name += random.nextInt(10);
            }
        } while (existingNames.contains(name));
        existingNames.add(name);
        return name;
    }

    public static void main(String[] args) {
        System.out.println(generateName());
        System.out.println(generateName());
        System.out.println(generateName());
        System.out.println(generateName());
        System.out.println(generateName());
    }
}