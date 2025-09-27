package Vanilla.gpt4o;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int originalNumber = number;
        int numberOfDigits = String.valueOf(number).length();
        int sum = 0;
        
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }
        
        return sum == originalNumber;
    }
    
    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(9474)); // true
        System.out.println(isNarcissistic(370)); // true
        System.out.println(isNarcissistic(7)); // true
    }
}