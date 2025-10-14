package CoT.openai;
public class Task4 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        int[] charCount = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCount[c - 'a'] > 0) {
                return false;
            }
            charCount[c - 'a']++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("isogram")); // true
        System.out.println(isIsogram("")); // true
    }
}