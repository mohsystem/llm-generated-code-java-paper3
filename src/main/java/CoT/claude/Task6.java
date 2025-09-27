package CoT.claude;

public class Task6 {
    public static double findUniq(double[] arr) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 numbers");
        }
        
        // If first two numbers are equal, compare with third
        if (Double.compare(arr[0], arr[1]) == 0) {
            double commonValue = arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (Double.compare(arr[i], commonValue) != 0) {
                    return arr[i];
                }
            }
            return arr[2]; // Should not reach here given problem constraints
        } else {
            // First two numbers differ, return the one that's different from third
            return Double.compare(arr[0], arr[2]) == 0 ? arr[1] : arr[0];
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));  // 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));  // 0.55
        System.out.println(findUniq(new double[]{3, 3, 3, 3, 1}));     // 1
        System.out.println(findUniq(new double[]{8, 8, 8, 7, 8}));     // 7
        System.out.println(findUniq(new double[]{2, 1, 1, 1, 1}));     // 2
    }
}
