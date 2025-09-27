package ZeroShot.codestral;
public class Task59 {
    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(Character.toUpperCase(s.charAt(i)));
            for (int j = 0; j < i; j++) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
        System.out.println(accum("cwAt"));
    }
}