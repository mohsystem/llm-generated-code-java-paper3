package CoT.codestral;
public class Task143 {
    public static void sortArray(int[] arr) {
        java.util.Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        sortArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}