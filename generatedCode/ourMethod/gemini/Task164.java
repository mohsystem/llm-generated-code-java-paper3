package ourMethod.gemini;
import java.util.Arrays;
import java.util.Comparator;

public class Task164 {

    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                String lastName1 = name1.split(" ")[1];
                String lastName2 = name2.split(" ")[1];
                int len1 = lastName1.length();
                int len2 = lastName2.length();

                if (len1 != len2) {
                    return len1 - len2;
                } else {
                    return lastName1.compareTo(lastName2);
                }
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] testCase1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(testCase1)));

        String[] testCase2 = {"Kate Hudson", "Emma Stone", "Jennifer Aniston"};
        System.out.println(Arrays.toString(lastNameLensort(testCase2)));

        String[] testCase3 = {"Sandra Bullock", "Julia Roberts", "Nicole Kidman"};
        System.out.println(Arrays.toString(lastNameLensort(testCase3)));

        String[] testCase4 = {"Scarlett Johansson", "Elizabeth Olsen", "Brie Larson"};
        System.out.println(Arrays.toString(lastNameLensort(testCase4)));

        String[] testCase5 = {"Angelina Jolie", "Jennifer Lawrence", "Meryl Streep"};
        System.out.println(Arrays.toString(lastNameLensort(testCase5)));

    }
}