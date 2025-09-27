package CoT.claude;

import java.util.*;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, (a, b) -> {
            String lastNameA = a.substring(a.lastIndexOf(" ") + 1);
            String lastNameB = b.substring(b.lastIndexOf(" ") + 1);
            
            if(lastNameA.length() != lastNameB.length()) {
                return lastNameA.length() - lastNameB.length();
            }
            return lastNameA.compareTo(lastNameB);
        });
        return names;
    }
    
    public static void main(String[] args) {
        // Test case 1
        String[] test1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        System.out.println(Arrays.toString(lastNameLensort(test1)));
        
        // Test case 2
        String[] test2 = {"John Doe", "Jane Smith", "Bob Lee", "Alice Wong"};
        System.out.println(Arrays.toString(lastNameLensort(test2)));
        
        // Test case 3
        String[] test3 = {"James Bond", "Mary Gold", "Peter Bond", "Susan Park"};
        System.out.println(Arrays.toString(lastNameLensort(test3)));
        
        // Test case 4
        String[] test4 = {"Tom Cruz", "Tim Allen", "Ana Bell", "Bob Chen"};
        System.out.println(Arrays.toString(lastNameLensort(test4)));
        
        // Test case 5
        String[] test5 = {"Sarah Connor", "John Smith", "Mary Wilson", "David Brown", "Lisa Green"};
        System.out.println(Arrays.toString(lastNameLensort(test5)));
    }
}
