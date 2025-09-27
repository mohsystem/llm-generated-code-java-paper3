package Vanilla.codestral;
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
        Arrays.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                String[] aLastName = a.split(" ");
                String[] bLastName = b.split(" ");
                if (aLastName[1].length() != bLastName[1].length()) {
                    return aLastName[1].length() - bLastName[1].length();
                } else {
                    return aLastName[1].compareTo(bLastName[1]);
                }
            }
        });
        return names;
    }
}