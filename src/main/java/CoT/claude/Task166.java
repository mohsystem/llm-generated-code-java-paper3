package CoT.claude;

public class Task166 {
    public static int[] posNegSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        
        // Extract positive numbers into separate list
        java.util.List<Integer> positives = new java.util.ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                positives.add(num);
            }
        }
        
        // Sort positive numbers
        java.util.Collections.sort(positives);
        
        // Put numbers back maintaining negative positions
        int posIndex = 0;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[i] = positives.get(posIndex++);
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
