package ourMethod.llama31;
public class Task59 {
    public static String accum(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Ensure the character is a letter
            if (Character.isLetter(c)) {
                // Capitalize the first letter and repeat it i+1 times
                result.append(Character.toUpperCase(c));
                for (int j = 1; j <= i; j++) {
                    result.append(Character.toLowerCase(c));
                }
                // Add a hyphen after each character except the last one
                if (i < str.length() - 1) {
                    result.append("-");
                }
            } else {
                // Handle non-letter characters by skipping them
                continue;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));  // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty"));  // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt"));  // "C-Ww-Aaa-Tttt"
    }
}