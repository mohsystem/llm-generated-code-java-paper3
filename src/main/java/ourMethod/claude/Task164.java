package ourMethod.claude;

import java.util.*;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                String lastName1 = name1.substring(name1.lastIndexOf(" ") + 1);
                String lastName2 = name2.substring(name2.lastIndexOf(" ") + 1);
                
                if (lastName1.length() != lastName2.length()) {
                    return lastName1.length() - lastName2.length();
                }
                return lastName1.compareTo(lastName2);
            }
        });
        
        return names;
    }
    
    public static void main(String[] args) {
        // Test case 1
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", 
                         "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));
        
        // Test case 2
        String[] test2 = {"John Doe", "Jane Smith", "Bob Lee"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));
        
        // Test case 3
        String[] test3 = {"Alice Wong", "Peter Wong", "Mary Wong"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));
        
        // Test case 4
        String[] test4 = {"James Wilson"};
        System.out.println(Arrays.toString(lastNameLensort(test4)));
        
        // Test case 5
        String[] test5 = {};
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}
