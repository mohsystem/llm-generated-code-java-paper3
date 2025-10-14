package ourMethodv2.gpt4o;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public static int[] removeSmallest(int[] numbers) {
        if (numbers.length == 0) return new int[0];
        
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                resultList.add(numbers[i]);
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeSmallest(new int[]{1, 2, 3, 4, 5}))); // [2, 3, 4, 5]
        System.out.println(Arrays.toString(removeSmallest(new int[]{5, 3, 2, 1, 4}))); // [5, 3, 2, 4]
        System.out.println(Arrays.toString(removeSmallest(new int[]{2, 2, 1, 2, 1}))); // [2, 2, 2, 1]
        System.out.println(Arrays.toString(removeSmallest(new int[]{}))); // []
        System.out.println(Arrays.toString(removeSmallest(new int[]{1}))); // []
    }
}