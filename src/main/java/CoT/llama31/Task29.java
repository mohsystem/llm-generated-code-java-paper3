package CoT.llama31;
// Java
public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null; // This should not be reached based on problem constraints
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3};
        int[] result1 = twoSum(numbers1, 4);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] numbers2 = {3, 2, 4};
        int[] result2 = twoSum(numbers2, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] numbers3 = {10, 20, 30, 40};
        int[] result3 = twoSum(numbers3, 50);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] numbers4 = {5, 10, 15, 20};
        int[] result4 = twoSum(numbers4, 25);
        System.out.println("[" + result4[0] + ", " + result4[1] + "]");

        int[] numbers5 = {2, 4, 6, 8};
        int[] result5 = twoSum(numbers5, 10);
        System.out.println("[" + result5[0] + ", " + result5[1] + "]");
    }
}