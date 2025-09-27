package ourMethod.llama31;
public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // This line should not be reached given the problem constraints
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3};
        int[] result1 = twoSum(numbers1, 4);
        System.out.println("Indices: (" + result1[0] + ", " + result1[1] + ")");

        int[] numbers2 = {3, 2, 4};
        int[] result2 = twoSum(numbers2, 6);
        System.out.println("Indices: (" + result2[0] + ", " + result2[1] + ")");
    }
}