package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task166 {
    public static List<Integer> posNegSort(List<Integer> nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            }
        }
        Collections.sort(pos);
        int posIndex = 0;
        for (int num : nums) {
            if (num > 0) {
                result.add(pos.get(posIndex++));
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
        System.out.println(posNegSort(Arrays.asList(-2, 1, -1, 2)));
    }
}