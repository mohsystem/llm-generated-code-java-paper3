package CoT.gemini;
class Task59 {
    public String accum(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                sb.append(Character.toLowerCase(c));
            }
            if (i < s.length() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Task59 task59 = new Task59();
        System.out.println(task59.accum("abcd"));
        System.out.println(task59.accum("RqaEzty"));
        System.out.println(task59.accum("cwAt"));
        System.out.println(task59.accum("ZpglnRWvg"));
        System.out.println(task59.accum("NyffsGeyylB"));

    }
}