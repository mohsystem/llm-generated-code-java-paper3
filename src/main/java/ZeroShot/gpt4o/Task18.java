package ZeroShot.gpt4o;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int bit : binaryArray) {
            result = (result << 1) | bit;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binaryArrayToInt(new int[]{0, 0, 0, 1})); // 1
        System.out.println(binaryArrayToInt(new int[]{0, 0, 1, 0})); // 2
        System.out.println(binaryArrayToInt(new int[]{0, 1, 0, 1})); // 5
        System.out.println(binaryArrayToInt(new int[]{1, 0, 0, 1})); // 9
        System.out.println(binaryArrayToInt(new int[]{0, 1, 1, 0})); // 6
    }
}