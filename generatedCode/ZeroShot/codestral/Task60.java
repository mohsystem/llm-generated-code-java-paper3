package ZeroShot.codestral;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder sb = new StringBuilder();
        int pow = 1;

        while (num > 0) {
            int digit = num % 10;
            num /= 10;

            if (digit != 0) {
                if (sb.length() > 0) {
                    sb.insert(0, " + ");
                }
                sb.insert(0, digit * pow);
            }

            pow *= 10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(70304));
    }
}