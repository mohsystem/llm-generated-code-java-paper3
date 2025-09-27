package CoT.gpt4o;
import java.util.*;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, new Comparator<String>() {
            public int compare(String name1, String name2) {
                String lastName1 = name1.split(" ")[1];
                String lastName2 = name2.split(" ")[1];
                if (lastName1.length() == lastName2.length()) {
                    return lastName1.compareTo(lastName2);
                }
                return Integer.compare(lastName1.length(), lastName2.length());
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        String[] result1 = lastNameLensort(test1);
        System.out.println(Arrays.toString(result1));

        String[] test2 = {"Alice B", "Bob C", "Charlie D"};
        String[] result2 = lastNameLensort(test2);
        System.out.println(Arrays.toString(result2));

        String[] test3 = {"Xander Y", "Yasmine Z", "Zane A"};
        String[] result3 = lastNameLensort(test3);
        System.out.println(Arrays.toString(result3));

        String[] test4 = {"Anna Banana", "Ben Apple", "Cathy Cherry"};
        String[] result4 = lastNameLensort(test4);
        System.out.println(Arrays.toString(result4));

        String[] test5 = {"Henry Ford", "Thomas Edison", "Nikola Tesla"};
        String[] result5 = lastNameLensort(test5);
        System.out.println(Arrays.toString(result5));
    }
}