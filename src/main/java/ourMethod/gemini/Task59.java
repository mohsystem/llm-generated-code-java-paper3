package ourMethod.gemini;
import java.lang.StringBuilder;

class Task59 {
    public String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(c));
            }
            if (i < s.length() - 1) {
                result.append("-");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Task59 task59 = new Task59();
        System.out.println(task59.accum("abcd")); // Expected: "A-Bb-Ccc-Dddd"
        System.out.println(task59.accum("RqaEzty")); // Expected: "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(task59.accum("cwAt")); // Expected: "C-Ww-Aaa-Tttt"
        System.out.println(task59.accum("xyz")); // Expected: X-Yy-Zzz
        System.out.println(task59.accum("NyffsGeyylB")); // Expected: N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb
    }
}