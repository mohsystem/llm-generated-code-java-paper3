package ourMethod.claude;

public class Task18 {
    public static int convertBinaryArrayToInt(int[] binary) {
        if (binary == null || binary.length == 0) {
            return 0;
        }
        
        int result = 0;
        int power = 1;
        
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] != 0 && binary[i] != 1) {
                throw new IllegalArgumentException("Array must contain only 0s and 1s");
            }
            result += binary[i] * power;
            power *= 2;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(convertBinaryArrayToInt(new int[]{0, 0, 0, 1})); // 1
        System.out.println(convertBinaryArrayToInt(new int[]{0, 0, 1, 0})); // 2 
        System.out.println(convertBinaryArrayToInt(new int[]{0, 1, 0, 1})); // 5
        System.out.println(convertBinaryArrayToInt(new int[]{1, 0, 0, 1})); // 9
        System.out.println(convertBinaryArrayToInt(new int[]{1, 1, 1, 1})); // 15
    }
}
