package CoT.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task26 {
    public static int findOdd(int[] A) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : A) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return -1; // Should never reach here
    }

    public static void main(String[] args) {
        System.out.println(findOdd(new int[]{7})); // 7
        System.out.println(findOdd(new int[]{0})); // 0
        System.out.println(findOdd(new int[]{1,1,2})); // 2
        System.out.println(findOdd(new int[]{0,1,0,1,0})); // 0
        System.out.println(findOdd(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1})); // 4
    }
}