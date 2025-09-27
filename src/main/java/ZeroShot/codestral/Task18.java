package ZeroShot.codestral;
public class Task18 {
    public static int binaryArrayToInt(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 2 + arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binaryArrayToInt(new int[]{0, 0, 0, 1})); // 1
        System.out.println(binaryArrayToInt(new int[]{0, 0, 1, 0})); // 2
        System.out.println(binaryArrayToInt(new int[]{0, 1, 0, 1})); // 5
        System.out.println(binaryArrayToInt(new int[]{1, 0, 0, 1})); // 9
        System.out.println(binaryArrayToInt(new int[]{0, 0, 1, 0})); // 2
    }
}