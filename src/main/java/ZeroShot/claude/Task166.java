package ZeroShot.claude;

public class Task166 {
    public static int[] posNegSort(int[] arr) {
        if (arr.length == 0) return arr;
        
        // Store positive numbers and their indices
        java.util.List<Integer> positives = new java.util.ArrayList<>();
        java.util.List<Integer> posIndices = new java.util.ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positives.add(arr[i]);
                posIndices.add(i);
            }
        }
        
        // Sort positive numbers
        java.util.Collections.sort(positives);
        
        // Create result array
        int[] result = arr.clone();
        for (int i = 0; i < positives.size(); i++) {
            result[posIndices.get(i)] = positives.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{})));
        System.out.println(java.util.Arrays.toString(posNegSort(new int[]{1, -2, 3, -4, 5})));
    }
}
