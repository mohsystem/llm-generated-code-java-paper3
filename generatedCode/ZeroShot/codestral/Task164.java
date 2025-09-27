package ZeroShot.codestral;
import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(names, Comparator.comparingInt((String name) -> name.split(" ")[1].length())
                .thenComparing(name -> name.split(" ")[1]));
        return names;
    }
}