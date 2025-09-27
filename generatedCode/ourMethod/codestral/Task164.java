package ourMethod.codestral;
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
            public int compare(String name1, String name2) {
                String lastName1 = name1.substring(name1.lastIndexOf(' ') + 1);
                String lastName2 = name2.substring(name2.lastIndexOf(' ') + 1);

                int lengthComparison = Integer.compare(lastName1.length(), lastName2.length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    return lastName1.compareTo(lastName2);
                }
            }
        });
        return names;
    }
}