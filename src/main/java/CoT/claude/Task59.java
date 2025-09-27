package CoT.claude;

public class Task59 {
    public static String accum(String input) {
        if (input == null) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > 0) result.append('-');
            char c = input.charAt(i);
            result.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));      // A-Bb-Ccc-Dddd
        System.out.println(accum("RqaEzty"));   // R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy
        System.out.println(accum("cwAt"));      // C-Ww-Aaa-Tttt
        System.out.println(accum("ZpglnRxqen")); // Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn
        System.out.println(accum("NyffsGeyylB")); // N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb
    }
}
