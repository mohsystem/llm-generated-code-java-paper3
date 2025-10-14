package ourMethodv2.gpt4o;
public class Task4 {
    public static boolean isIsogram(String input) {
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
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