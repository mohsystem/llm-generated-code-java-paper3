package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task166 {
    public static List<Integer> posNegSort(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : arr) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        Collections.sort(positiveNumbers);

        int positiveIndex = 0;
        for (Integer num : arr) {
            if (num > 0) {
                result.add(positiveNumbers.get(positiveIndex++));
            } else {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(posNegSort(Arrays.asList(6, 3, -2, 5, -8, 2, -2)));
        System.out.println(posNegSort(Arrays.asList(6, 5, 4, -1, 3, 2, -1, 1)));
        System.out.println(posNegSort(Arrays.asList(-5, -5, -5, -5, 7, -5)));
        System.out.println(posNegSort(Arrays.asList()));
        System.out.println(posNegSort(Arrays.asList(1, 2, 3, 4, 5)));
    }
}