package ourMethod.llama31;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        String numStr = String.valueOf(number);
        int numDigits = numStr.length();
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            sum += (int) Math.pow(Character.getNumericValue(c), numDigits);
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int[] testCases = {153, 407, 1634, 1652, 9474};
        for (int testCase : testCases) {
            System.out.println(testCase + " is narcissistic: " + isNarcissistic(testCase));
        }
    }
}