package ourMethod.claude;

public class Task166 {
    public static int[] posNegSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        
        // Get positive numbers
        int posCount = 0;
        for (int num : arr) {
            if (num > 0) {
                posCount++;
            }
        }
        
        // Create array of positive numbers
        int[] positives = new int[posCount];
        int posIndex = 0;
        for (int num : arr) {
            if (num > 0) {
                positives[posIndex++] = num;
            }
        }
        
        // Sort positive numbers
        java.util.Arrays.sort(positives);
        
        // Create result array by placing sorted positives in original positions
        int[] result = new int[arr.length];
        posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[i] = positives[posIndex++];
            } else {
                result[i] = arr[i];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{1, 2, 3, 4, 5})));
    }
}
