package Vanilla.llama31;
public class Task163 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println("Length of the Longest consecutive subsequence is " + longestConsecutive(new int[] {1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println("Length of the Longest consecutive subsequence is " + longestConsecutive(new int[] {1, 2, 3, 10, 11, 15})); // 3
        System.out.println("Length of the Longest consecutive subsequence is " + longestConsecutive(new int[] {5, 4, 2, 1})); // 2
        System.out.println("Length of the Longest consecutive subsequence is " + longestConsecutive(new int[] {3, 5, 7, 10, 15})); // 1
        System.out.println("Length of the Longest consecutive subsequence is " + longestConsecutive(new int[] {})); // 0
    }
}