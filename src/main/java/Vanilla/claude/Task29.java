package Vanilla.claude;

public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] result1 = twoSum(new int[]{1, 2, 3}, 4);
        System.out.println(result1[0] + "," + result1[1]); // 0,2
        
        // Test case 2 
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result2[0] + "," + result2[1]); // 1,2
        
        // Test case 3
        int[] result3 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result3[0] + "," + result3[1]); // 0,1
        
        // Test case 4
        int[] result4 = twoSum(new int[]{3, 3}, 6);
        System.out.println(result4[0] + "," + result4[1]); // 0,1
        
        // Test case 5
        int[] result5 = twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
        System.out.println(result5[0] + "," + result5[1]); // 2,4
    }
}
