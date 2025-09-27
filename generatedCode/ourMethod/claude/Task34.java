package ourMethod.claude;

public class Task34 {
    public static boolean isNarcissistic(int number) {
        if (number <= 0) {
            return false;
        }
        
        String numStr = String.valueOf(number);
        int power = numStr.length();
        long sum = 0; // Using long to prevent overflow
        
        for (char digit : numStr.toCharArray()) {
            sum += Math.pow(Character.getNumericValue(digit), power);
            if (sum > Integer.MAX_VALUE) { // Prevent overflow
                return false;
            }
        }
        
        return sum == number;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(7));    // true
        System.out.println(isNarcissistic(370));  // true
        System.out.println(isNarcissistic(1000)); // false
    }
}
