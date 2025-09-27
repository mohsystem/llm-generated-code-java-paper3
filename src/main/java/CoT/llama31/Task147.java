package CoT.llama31;
public class Task147 {

    public static int findKthLargest(int[] array, int k) {
        // Sort the array in descending order
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[k - 1];
    }
}