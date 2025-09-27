package Vanilla.gemini;
import java.util.Arrays;
import java.util.Comparator;

public class Task164 {

    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, Comparator.comparingInt(s -> s.split(" ")[1].length()).thenComparing(s -> s.split(" ")[1]));
        return names;
    }

    public static void main(String[] args) {
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));

        String[] test2 = {"Kate Winslet", "Leonardo DiCaprio", "Tom Hanks", "Meryl Streep"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));

        String[] test3 = {"Brad Pitt", "Angelina Jolie", "George Clooney", "Julia Roberts"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));

        String[] test4 = {};
        System.out.println(Arrays.toString(lastNameLensort(test4)));

        String[] test5 = {"Single Name"};
        System.out.println(Arrays.toString(lastNameLensort(test5)));


    }
}