package ourMethod.gpt4o;
public class Task4 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        boolean[] charSet = new boolean[26];
        for (char c : str.toCharArray()) {
            if (charSet[c - 'a']) {
                return false;
            }
            charSet[c - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
        System.out.println(isIsogram("")); // true
        System.out.println(isIsogram("isogram")); // true
    }
}