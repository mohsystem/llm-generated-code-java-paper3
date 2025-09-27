package CoT.llama31;
public class Task4 {
    public static boolean isIsogram(String str) {
        int[] mapHash = new int[26];
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            mapHash[c - 'a']++;
            if (mapHash[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("a")); // true
    }
}