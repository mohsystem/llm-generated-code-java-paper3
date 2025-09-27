package Vanilla.llama31;
public class Task14 {
    public static int findMiddleIndex(int[] arr) {
        if (arr.length == 0) return -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int num : arr) rightSum += num;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 3, 2, 1};
        int[] test2 = {1, 100, 50, -51, 1, 1};
        int[] test3 = {20, 10, -80, 10, 10, 15, 35};
        int[] test4 = {1, 2, 3};
        int[] test5 = {};

        System.out.println(findMiddleIndex(test1)); // Output: 3
        System.out.println(findMiddleIndex(test2)); // Output: 1
        System.out.println(findMiddleIndex(test3)); // Output: 0
        System.out.println(findMiddleIndex(test4)); // Output: -1
        System.out.println(findMiddleIndex(test5)); // Output: -1
    }
}