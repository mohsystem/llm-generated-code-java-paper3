package CoT.openai;
public class Task163 {

    public static int longestRun(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;

        int maxRun = 1;
        int currentRun = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1] + 1 || numbers[i] == numbers[i - 1] - 1) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            maxRun = Math.max(maxRun, currentRun);
        }

        return maxRun;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{9, 8, 7, 6, 5, 4, 3})); // 7
    }
}