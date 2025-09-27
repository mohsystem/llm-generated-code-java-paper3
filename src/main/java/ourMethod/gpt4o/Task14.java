package ourMethod.gpt4o;
public class Task14 {
    public static int findEqualSidesIndex(int[] arr) {
        int totalSum = 0, leftSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }
        
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += arr[i];
        }
        
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEqualSidesIndex(new int[]{1, 2, 3, 4, 3, 2, 1})); // Output: 3
        System.out.println(findEqualSidesIndex(new int[]{1, 100, 50, -51, 1, 1})); // Output: 1
        System.out.println(findEqualSidesIndex(new int[]{20, 10, -80, 10, 10, 15, 35})); // Output: 0
        System.out.println(findEqualSidesIndex(new int[]{1, 2, 3, 4, 5, 6})); // Output: -1
        System.out.println(findEqualSidesIndex(new int[]{10, -10, 10, -10, 10, -10, 10})); // Output: 0
    }
}