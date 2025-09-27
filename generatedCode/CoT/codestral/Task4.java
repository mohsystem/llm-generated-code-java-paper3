package CoT.codestral;
public class Task4 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        int[] counter = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            counter[index]++;
            if (counter[index] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics")); // true
        System.out.println(isIsogram("aba")); // false
        System.out.println(isIsogram("moOse")); // false
    }
}