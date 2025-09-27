package ourMethod.gpt4o;
public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0]; // No solution found
    }

    public static void main(String[] args) {
        // Test cases
        int[] result1 = twoSum(new int[] { 1, 2, 3 }, 4);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] result3 = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] result4 = twoSum(new int[] { 3, 3 }, 6);
        System.out.println("[" + result4[0] + ", " + result4[1] + "]");

        int[] result5 = twoSum(new int[] { 0, 4, 3, 0 }, 0);
        System.out.println("[" + result5[0] + ", " + result5[1] + "]");
    }
}