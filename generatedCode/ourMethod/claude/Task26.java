package ourMethod.claude;

public class Task26 {
    public static int findOdd(int[] arr) {
        // Using XOR to find number appearing odd times
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findOdd(new int[]{7})); // 7
        System.out.println(findOdd(new int[]{0})); // 0  
        System.out.println(findOdd(new int[]{1,1,2})); // 2
        System.out.println(findOdd(new int[]{0,1,0,1,0})); // 0
        System.out.println(findOdd(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1})); // 4
    }
}
