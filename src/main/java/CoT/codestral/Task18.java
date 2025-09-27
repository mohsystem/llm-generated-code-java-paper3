package CoT.codestral;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] != 0 && binaryArray[i] != 1) {
                throw new IllegalArgumentException("Invalid binary number");
            }
            result = (result << 1) | binaryArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binaryArrayToInt(new int[]{0, 0, 0, 1})); // 1
        System.out.println(binaryArrayToInt(new int[]{0, 0, 1, 0})); // 2
        System.out.println(binaryArrayToInt(new int[]{0, 1, 0, 1})); // 5
        // Add more test cases as needed
    }
}