package ZeroShot.openai;
public class Task30 {
    public static String longest(String s1, String s2) {
        String combined = s1 + s2;
        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();
        
        for (char c : combined.toCharArray()) {
            int index = c - 'a';
            if (!seen[index]) {
                seen[index] = true;
                result.append(c);
            }
        }
        
        char[] resultArray = result.toString().toCharArray();
        java.util.Arrays.sort(resultArray);
        
        return new String(resultArray);
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(longest("abc", "def"));
        System.out.println(longest("pqr", "stu"));
        System.out.println(longest("mno", "nop"));
    }
}