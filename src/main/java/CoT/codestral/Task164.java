package CoT.codestral;
import java.util.*;

public class Task164 {
    public static void main(String[] args) {
        String[] names = {
            "Jennifer Figueroa",
            "Heather Mcgee",
            "Amanda Schwartz",
            "Nicole Yoder",
            "Melissa Hoffman"
        };
        System.out.println(Arrays.toString(lastNameLensort(names)));
    }

    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, (a, b) -> {
            String[] lastNameA = a.split(" ");
            String[] lastNameB = b.split(" ");
            if (lastNameA[1].length() == lastNameB[1].length()) {
                return lastNameA[1].compareTo(lastNameB[1]);
            }
            return lastNameA[1].length() - lastNameB[1].length();
        });
        return names;
    }
}