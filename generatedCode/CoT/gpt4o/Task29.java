package CoT.gpt4o;
public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Return -1, -1 if no solution is found (shouldn't happen given problem statement)
    }

    public static void main(String[] args) {
        int[] result1 = twoSum(new int[]{1, 2, 3}, 4);
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        int[] result3 = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result4 = twoSum(new int[]{5, 75, 25}, 100);
        int[] result5 = twoSum(new int[]{1, 3, 4, 2}, 6);

        System.out.println("{" + result1[0] + ", " + result1[1] + "}");
        System.out.println("{" + result2[0] + ", " + result2[1] + "}");
        System.out.println("{" + result3[0] + ", " + result3[1] + "}");
        System.out.println("{" + result4[0] + ", " + result4[1] + "}");
        System.out.println("{" + result5[0] + ", " + result5[1] + "}");
    }
}