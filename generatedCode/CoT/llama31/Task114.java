package CoT.llama31;
public class Task114 {
    public static void main(String[] args) {
        // Test cases
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "GeeksforGeeks";
        String str4 = "this is init";
        String str5 = " added now";

        System.out.println("Original String: " + str1);
        System.out.println("Copied String: " + copyString(str1));
        System.out.println("Concatenated String: " + concatenateStrings(str1, str2));
        System.out.println("Modified String: " + modifyString(str3, 6, 'F'));
        System.out.println("Deleted Character String: " + deleteCharacter(str3, 'G'));
        System.out.println("Concatenated String: " + concatenateStrings(str4, str5));
    }

    public static String copyString(String str) {
        return str;
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String modifyString(String str, int index, char ch) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    public static String deleteCharacter(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}