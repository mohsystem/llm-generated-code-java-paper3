package ourMethod.claude;

public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        // Input validation
        if (numbers == null || numbers.length != 10) {
            throw new IllegalArgumentException("Array must contain exactly 10 digits");
        }
        
        // Validate each digit
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("Each digit must be between 0 and 9");
            }
        }
        
        // Create phone number string using StringBuilder
        StringBuilder phoneNumber = new StringBuilder(14); // Pre-allocate exact size needed
        phoneNumber.append('(');
        for (int i = 0; i < 3; i++) {
            phoneNumber.append(numbers[i]);
        }
        phoneNumber.append(") ");
        for (int i = 3; i < 6; i++) {
            phoneNumber.append(numbers[i]); 
        }
        phoneNumber.append('-');
        for (int i = 6; i < 10; i++) {
            phoneNumber.append(numbers[i]);
        }
        
        return phoneNumber.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(createPhoneNumber(new int[] {1,2,3,4,5,6,7,8,9,0})); // Should print "(123) 456-7890"
        System.out.println(createPhoneNumber(new int[] {0,0,0,0,0,0,0,0,0,0})); // Should print "(000) 000-0000"
        System.out.println(createPhoneNumber(new int[] {9,9,9,9,9,9,9,9,9,9})); // Should print "(999) 999-9999"
        System.out.println(createPhoneNumber(new int[] {1,1,1,2,2,2,3,3,3,3})); // Should print "(111) 222-3333"
        System.out.println(createPhoneNumber(new int[] {0,1,2,3,4,5,6,7,8,9})); // Should print "(012) 345-6789"
    }
}
