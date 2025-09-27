package ZeroShot.gemini;
import java.util.Arrays;
import java.util.Comparator;

class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] name1 = s1.split(" ");
                String[] name2 = s2.split(" ");
                int len1 = name1[name1.length - 1].length();
                int len2 = name2[name2.length - 1].length();
                if (len1 != len2) {
                    return len1 - len2;
                } else {
                    return name1[name1.length - 1].compareTo(name2[name2.length - 1]);
                }
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));

        String[] test2 = {"Kate Winslet", "Leonardo Dicaprio"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));


        String[] test3 = {"Wayne Rooney", "Cristiano Ronaldo"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));

        String[] test4 = {"Bruce Willis", "Bruce Lee"};
        System.out.println(Arrays.toString(lastNameLensort(test4)));

        String[] test5 = {};
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}