package CoT.claude;

public class Task18 {
    public static int binaryArrayToNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] != 1) {
                return 0;
            }
            result = (result << 1) | arr[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(binaryArrayToNumber(new int[]{0, 0, 0, 1})); // 1
        System.out.println(binaryArrayToNumber(new int[]{0, 0, 1, 0})); // 2
        System.out.println(binaryArrayToNumber(new int[]{0, 1, 0, 1})); // 5
        System.out.println(binaryArrayToNumber(new int[]{1, 0, 0, 1})); // 9
        System.out.println(binaryArrayToNumber(new int[]{1, 1, 1, 1})); // 15
    }
}
