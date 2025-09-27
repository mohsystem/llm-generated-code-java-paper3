package CoT.claude;

public class Task34 {
    public static boolean isNarcissistic(int number) {
        if (number <= 0) return false;
        
        String numStr = String.valueOf(number);
        int len = numStr.length();
        int sum = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, len);
            temp /= 10;
        }
        
        return sum == number;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(370));  // true
        System.out.println(isNarcissistic(407));  // true
        System.out.println(isNarcissistic(1634)); // true
    }
}
