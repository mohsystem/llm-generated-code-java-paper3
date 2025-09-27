package CoT.gpt4o;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int originalNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length();
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(9474)); // true
        System.out.println(isNarcissistic(9475)); // false
        System.out.println(isNarcissistic(407));  // true
    }
}