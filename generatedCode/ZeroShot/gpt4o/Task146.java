package ZeroShot.openai;
public class Task146 {
    public static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 5};
        int[] test2 = {1, 3, 4, 5};
        int[] test3 = {2, 3, 4, 5};
        int[] test4 = {1, 2, 4, 5};
        int[] test5 = {1, 2, 3, 4};
        
        System.out.println(findMissingNumber(test1, 5)); // Output: 4
        System.out.println(findMissingNumber(test2, 5)); // Output: 2
        System.out.println(findMissingNumber(test3, 5)); // Output: 1
        System.out.println(findMissingNumber(test4, 5)); // Output: 3
        System.out.println(findMissingNumber(test5, 5)); // Output: 5
    }
}