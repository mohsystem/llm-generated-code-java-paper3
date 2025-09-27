package ourMethod.codestral;
import java.util.Arrays;
import java.util.ArrayList;

public class Task166 {
    public static Integer[] posNegSort(Integer[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (Integer num : nums) {
            if (num > 0) pos.add(num);
        }
        Collections.sort(pos);
        int posIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[i] = pos.get(posIndex);
                posIndex++;
            }
        }
        return nums;
    }
}