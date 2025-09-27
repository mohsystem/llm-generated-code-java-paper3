package ZeroShot.llama31;
public class Task59 {
    public static String accum(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
            if (i < str.length() - 1) {
                result.append("-");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd")); // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty")); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt")); // "C-Ww-Aaa-Tttt"
        System.out.println(accum("")); // ""
        System.out.println(accum("a")); // "A"
    }
}