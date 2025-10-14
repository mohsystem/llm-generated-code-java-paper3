package ourMethod.openai;
import java.util.Arrays;
import java.util.Comparator;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String lastNameA = a.substring(a.lastIndexOf(" ") + 1);
                String lastNameB = b.substring(b.lastIndexOf(" ") + 1);
                if (lastNameA.length() != lastNameB.length()) {
                    return Integer.compare(lastNameA.length(), lastNameB.length());
                }
                return lastNameA.compareTo(lastNameB);
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        String[] test2 = {"John Doe", "Jane Smith", "Emily Davis", "Michael Johnson", "Chris Lee"};
        String[] test3 = {"Anna Bell", "Zoe White", "Olivia Green", "Liam Black", "Emma Gray"};
        String[] test4 = {"Catherine Zeta", "Paul Walker", "John Woo", "Morgan Freeman", "Samuel L Jackson"};
        String[] test5 = {"Alice Wonderland", "Bob Builder", "Charlie Brown", "Donald Duck", "Elon Musk"};

        System.out.println(Arrays.toString(lastNameLensort(test1)));
        System.out.println(Arrays.toString(lastNameLensort(test2)));
        System.out.println(Arrays.toString(lastNameLensort(test3)));
        System.out.println(Arrays.toString(lastNameLensort(test4)));
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}