package ZeroShot.gpt4o;
public class Task14 {
    public static int findEqualIndex(int[] arr) {
        int totalSum = 0, leftSum = 0;
        for (int num : arr) totalSum += num;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - leftSum - arr[i]) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEqualIndex(new int[]{1, 2, 3, 4, 3, 2, 1})); // Output: 3
        System.out.println(findEqualIndex(new int[]{1, 100, 50, -51, 1, 1})); // Output: 1
        System.out.println(findEqualIndex(new int[]{20, 10, -80, 10, 10, 15, 35})); // Output: 0
        System.out.println(findEqualIndex(new int[]{1, 2, 3, 4, 5, 6})); // Output: -1
        System.out.println(findEqualIndex(new int[]{10, -10, 10, -10, 10, -10, 10})); // Output: -1
    }
}