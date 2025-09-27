package ZeroShot.codestral;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Task21 {
    public static int[] removeSmallest(int[] numbers) {
        if (numbers.length == 0) {
            return numbers;
        }

        int min = Arrays.stream(numbers).min().getAsInt();
        return IntStream.of(numbers)
                .filter(n -> n != min || (n == min && Arrays.stream(numbers).anyMatch(num -> num == min && Arrays.stream(numbers).filter(x -> x == min).findFirst().getAsInt() != num)))
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeSmallest(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{5, 3, 2, 1, 4})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{2, 2, 1, 2, 1})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{1, 1, 1, 1, 1})));
    }
}