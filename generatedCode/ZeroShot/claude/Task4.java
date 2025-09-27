package ZeroShot.claude;

public class Task4 {
    public static boolean isIsogram(String str) {
        if (str == null || str.isEmpty()) return true;
        
        str = str.toLowerCase();
        boolean[] seen = new boolean[26];
        
        for (char c : str.toCharArray()) {
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("thumbscrew-japingly")); // true
    }
}
