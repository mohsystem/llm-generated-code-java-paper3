package Vanilla.claude;

public class Task6 {
    public static double findUniq(double[] arr) {
        if(arr[0] != arr[1] && arr[0] != arr[2]) return arr[0];
        if(arr[1] != arr[0] && arr[1] != arr[2]) return arr[1];
        
        double commonNum = arr[0] == arr[1] ? arr[0] : arr[2];
        
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] != commonNum) return arr[i];
        }
        return commonNum;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // 2.0
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // 0.55
        System.out.println(findUniq(new double[]{3, 3, 3, 3, 1})); // 1.0
        System.out.println(findUniq(new double[]{8, 8, 8, 7, 8})); // 7.0
        System.out.println(findUniq(new double[]{2, 1, 2, 2, 2})); // 1.0
    }
}
