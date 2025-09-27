package ZeroShot.codestral;
public class Task14 {
    public static int findEvenIndex(int[] arr) {
        int left = 0, right = 0;
        for (int i : arr) {
            right += i;
        }
        for (int i = 0; i < arr.length; i++) {
            right -= arr[i];
            if (left == right) {
                return i;
            }
            left += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[]{1,2,3,4,3,2,1})); // 3
        System.out.println(findEvenIndex(new int[]{1,100,50,-51,1,1})); // 1
        System.out.println(findEvenIndex(new int[]{20,10,-80,10,10,15,35})); // 0
        System.out.println(findEvenIndex(new int[]{1,2,3,4,5,6})); // -1
        System.out.println(findEvenIndex(new int[]{20,10,30,10,10,15,35})); // 3
    }
}