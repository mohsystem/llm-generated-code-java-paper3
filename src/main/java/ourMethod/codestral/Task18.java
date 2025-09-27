package ourMethod.codestral;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            result = (result << 1) | binaryArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binaryArrayToInt(new int[]{0, 0, 0, 1}));  // Output: 1
        System.out.println(binaryArrayToInt(new int[]{0, 0, 1, 0}));  // Output: 2
        // Add more test cases as needed
    }
}