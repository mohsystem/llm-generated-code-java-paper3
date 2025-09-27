package CoT.gpt4o;
public class Task14 {
    public static int findEqualSumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEqualSumIndex(new int[]{1, 2, 3, 4, 3, 2, 1})); // 3
        System.out.println(findEqualSumIndex(new int[]{1, 100, 50, -51, 1, 1})); // 1
        System.out.println(findEqualSumIndex(new int[]{20, 10, -80, 10, 10, 15, 35})); // 0
        System.out.println(findEqualSumIndex(new int[]{1, 2, 3, 4, 5, 6})); // -1
        System.out.println(findEqualSumIndex(new int[]{0, 0, 0, 0, 0, 0})); // 0
    }
}