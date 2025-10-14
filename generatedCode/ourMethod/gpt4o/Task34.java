package ourMethod.openai;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int numDigits = String.valueOf(number).length();
        int sum = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }
        
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(9474)); // true
        System.out.println(isNarcissistic(9475)); // false
        System.out.println(isNarcissistic(407)); // true
    }
}