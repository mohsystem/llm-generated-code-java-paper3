package CoT.gemini;
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
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));

        String[] test2 = {"Kate Winslet", "Leonardo DiCaprio"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));


        String[] test3 = {"Bruce Wayne", "Clark Kent", "Diana Prince"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));


        String[] test4 = {"Barack Obama", "Donald Trump", "Joe Biden"};
        System.out.println(Arrays.toString(lastNameLensort(test4)));

        String[] test5 = {"Beyonce Knowles", "Jay-Z", "Solange Knowles"};
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}