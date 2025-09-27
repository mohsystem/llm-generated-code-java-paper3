package ourMethod.claude;

import java.util.*;

public class Task22 {
    public static List<Object> filterList(List<Object> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        
        List<Object> result = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Integer && (Integer)item >= 0) {
                result.add(item);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(filterList(List.of(1, 2, "a", "b")));  // [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // [1, 0, 15] 
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(List.of())); // []
        System.out.println(filterList(null)); // []
    }
}
