package Vanilla.llama31;
public class Task98 {
    public static void main(String[] args) {
        String[] testCases = {"123", "456", "-789", "abc", "123.45"};
        for (String testCase : testCases) {
            try {
                System.out.println(convertToInt(testCase));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    public static int convertToInt(String s) {
        int num = 0;
        int n = s.length();
        int sign = 1;
        int i = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i < n; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                throw new NumberFormatException("Invalid input");
            }
            num = num * 10 + (s.charAt(i) - '0');
        }

        return num * sign;
    }
}