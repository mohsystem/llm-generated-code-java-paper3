package Vanilla.claude;

public class Task21 {
    public static int[] removeSmallest(int[] numbers) {
        if (numbers == null || numbers.length == 0) return new int[]{};
        
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        
        int[] result = new int[numbers.length-1];
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                result[j++] = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test case 1:");
        int[] arr1 = {1,2,3,4,5};
        int[] result1 = removeSmallest(arr1);
        for(int num : result1) System.out.print(num + " ");
        
        System.out.println("\\nTest case 2:");
        int[] arr2 = {5,3,2,1,4};
        int[] result2 = removeSmallest(arr2);
        for(int num : result2) System.out.print(num + " ");
        
        System.out.println("\\nTest case 3:");
        int[] arr3 = {2,2,1,2,1};
        int[] result3 = removeSmallest(arr3);
        for(int num : result3) System.out.print(num + " ");
        
        System.out.println("\\nTest case 4:");
        int[] arr4 = {};
        int[] result4 = removeSmallest(arr4);
        for(int num : result4) System.out.print(num + " ");
        
        System.out.println("\\nTest case 5:");
        int[] arr5 = {1};
        int[] result5 = removeSmallest(arr5);
        for(int num : result5) System.out.print(num + " ");
    }
}
