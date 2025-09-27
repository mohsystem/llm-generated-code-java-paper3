package ZeroShot.codestral;
public class Task143 {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1};
        sortArray(array);
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void sortArray(int[] array) {
        java.util.Arrays.sort(array);
    }
}