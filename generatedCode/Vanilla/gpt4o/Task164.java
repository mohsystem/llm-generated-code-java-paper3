package Vanilla.openai;
import java.util.Arrays;
import java.util.Comparator;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                String lastName1 = name1.substring(name1.lastIndexOf(" ") + 1);
                String lastName2 = name2.substring(name2.lastIndexOf(" ") + 1);
                if (lastName1.length() != lastName2.length()) {
                    return Integer.compare(lastName1.length(), lastName2.length());
                } else {
                    return lastName1.compareTo(lastName2);
                }
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        String[] test2 = {"Anna Smith", "Bob Brown", "Charlie Davis", "Daniel Evans", "Eva Adams"};
        String[] test3 = {"Xander Cage", "Bobby Drake", "Aaron Taylor", "Nina Simone", "Olivia Benson"};
        String[] test4 = {"John Doe", "Jane Roe", "Max Payne", "Clark Kent", "Bruce Wayne"};
        String[] test5 = {"Michael Jordan", "LeBron James", "Kobe Bryant", "Larry Bird", "Magic Johnson"};

        System.out.println(Arrays.toString(lastNameLensort(test1)));
        System.out.println(Arrays.toString(lastNameLensort(test2)));
        System.out.println(Arrays.toString(lastNameLensort(test3)));
        System.out.println(Arrays.toString(lastNameLensort(test4)));
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}