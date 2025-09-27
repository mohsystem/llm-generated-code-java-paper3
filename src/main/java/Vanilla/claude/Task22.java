package Vanilla.claude;

import java.util.*;

public class Task22 {
    public static List<Object> filterList(List<Object> list) {
        List<Object> result = new ArrayList<>();
        for(Object item : list) {
            if(item instanceof Integer) {
                result.add(item);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b")));
        
        // Test case 2 
        System.out.println(filterList(Arrays.asList(1, "a", "b", 0, 15)));
        
        // Test case 3
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 123)));
        
        // Test case 4
        System.out.println(filterList(Arrays.asList(1, 2, 3, 4, 5)));
        
        // Test case 5
        System.out.println(filterList(Arrays.asList("a", "b", "c")));
    }
}
