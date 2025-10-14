package ourMethodv2.gpt4o;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int num = number;
        int digits = String.valueOf(num).length();
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(9474)); // true
        System.out.println(isNarcissistic(9475)); // false
        System.out.println(isNarcissistic(370));  // true
    }
}