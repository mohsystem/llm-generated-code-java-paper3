package ZeroShot.codestral;
public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
    }
}