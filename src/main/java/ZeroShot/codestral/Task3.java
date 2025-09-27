package ZeroShot.codestral;
public class Task3 {
    public static boolean isPangram(String str) {
        str = str.toLowerCase();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (str.indexOf(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("This is not a pangram")); // false
        System.out.println(isPangram("1234567890")); // false
        System.out.println(isPangram("abcdefghijklmopqrstuvwxyz")); // false, missing 'n'
        System.out.println(isPangram("thequickbrownfoxjumpsoverthelazydog")); // true
    }
}