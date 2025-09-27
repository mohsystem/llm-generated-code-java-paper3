package ZeroShot.codestral;
public class Task4 {
    public static boolean isIsogram(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = Character.toLowerCase(str.charAt(i));
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
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