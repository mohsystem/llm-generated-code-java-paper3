package Vanilla.claude;

public class Task18 {
    public static int binaryArrayToNumber(int[] arr) {
        int result = 0;
        for(int bit : arr) {
            result = result * 2 + bit;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(binaryArrayToNumber(new int[]{0, 0, 0, 1})); // 1
        System.out.println(binaryArrayToNumber(new int[]{0, 0, 1, 0})); // 2
        System.out.println(binaryArrayToNumber(new int[]{0, 1, 0, 1})); // 5
        System.out.println(binaryArrayToNumber(new int[]{1, 0, 0, 1})); // 9
        System.out.println(binaryArrayToNumber(new int[]{1, 1, 1, 1})); // 15
    }
}
