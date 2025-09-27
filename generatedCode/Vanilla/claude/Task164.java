package Vanilla.claude;

import java.util.*;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, (a, b) -> {
            String lastNameA = a.substring(a.lastIndexOf(" ") + 1);
            String lastNameB = b.substring(b.lastIndexOf(" ") + 1);
            
            if (lastNameA.length() != lastNameB.length()) {
                return lastNameA.length() - lastNameB.length();
            }
            return lastNameA.compareTo(lastNameB);
        });
        return names;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));

        // Test Case 2
        String[] test2 = {"John Doe", "Jane Smith", "Bob Lee", "Alice Wang"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));

        // Test Case 3
        String[] test3 = {"Peter Parker", "Mary Jane", "Tony Stark"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));

        // Test Case 4
        String[] test4 = {"James Bond", "John Smith", "Jane Smith"};
        System.out.println(Arrays.toString(lastNameLensort(test4)));

        // Test Case 5
        String[] test5 = {"Single Name"};
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}
