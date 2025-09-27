package CoT.gemini;
import java.util.Arrays;

public class Task163 {

    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // Or throw an exception
        }

        if (arr.length == 1) {
            return 1;
        }
        
        Arrays.sort(arr);


        int longest = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                current++;
            } else if (arr[i] != arr[i-1]) {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        return Math.max(longest, current);
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(longestRun(new int[]{1,2,3,4,6,8,9,10,11})); //4

    }
}