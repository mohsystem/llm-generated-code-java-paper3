package ZeroShot.llama31;
public class Task146 {
    public static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int[] hash = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {1, 2, 3, 5};
        int[] arr3 = {1, 3, 4, 5};
        int[] arr4 = {2, 3, 4, 5};
        int[] arr5 = {1, 2, 3, 4};

        System.out.println("Missing number in arr1: " + missingNumber(arr1));
        System.out.println("Missing number in arr2: " + missingNumber(arr2));
        System.out.println("Missing number in arr3: " + missingNumber(arr3));
        System.out.println("Missing number in arr4: " + missingNumber(arr4));
        System.out.println("Missing number in arr5: " + missingNumber(arr5));
    }
}