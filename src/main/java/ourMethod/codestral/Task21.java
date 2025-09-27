package ourMethod.codestral;
import java.util.*;

public class Task21 {
    public static ArrayList<Integer> removeSmallest(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
                index = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                list.add(numbers[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(removeSmallest(new int[]{1, 2, 3, 4, 5}));
        System.out.println(removeSmallest(new int[]{5, 3, 2, 1, 4}));
        System.out.println(removeSmallest(new int[]{2, 2, 1, 2, 1}));
    }
}