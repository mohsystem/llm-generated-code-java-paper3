package Vanilla.openai;
public class Task60 {

    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int divisor = 10;
        int positionValue = 1;

        while (num > 0) {
            int remainder = num % divisor;
            if (remainder != 0) {
                result.insert(0, " + " + remainder * positionValue);
            }
            num /= 10;
            positionValue *= 10;
        }
        return result.substring(3);
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));    // "10 + 2"
        System.out.println(expandedForm(42));    // "40 + 2"
        System.out.println(expandedForm(70304)); // "70000 + 300 + 4"
        System.out.println(expandedForm(530));   // "500 + 30"
        System.out.println(expandedForm(8050));  // "8000 + 50"
    }
}