package ourMethod.codestral;
import java.util.Arrays;

public class Task143 {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 1};
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        Arrays.sort(array);
    }
}