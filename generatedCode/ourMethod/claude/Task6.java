package ourMethod.claude;

public class Task6 {
    public static double findUniq(double[] arr) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 elements");
        }
        
        // Handle first three elements to determine pattern
        if (Double.compare(arr[0], arr[1]) != 0) {
            return Double.compare(arr[0], arr[2]) == 0 ? arr[1] : arr[0];
        }
        
        double commonValue = arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (Double.compare(arr[i], commonValue) != 0) {
                return arr[i];
            }
        }
        
        throw new IllegalArgumentException("No unique element found");
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findUniq(new double[]{ 1, 1, 1, 2, 1, 1 })); // 2.0
        System.out.println(findUniq(new double[]{ 0, 0, 0.55, 0, 0 })); // 0.55
        System.out.println(findUniq(new double[]{ 1, 1, 1, 1, 1, 2 })); // 2.0
        System.out.println(findUniq(new double[]{ 2, 1, 1, 1, 1, 1 })); // 2.0
        System.out.println(findUniq(new double[]{ 1.0, 1.0, 1.1, 1.0 })); // 1.1
    }
}
