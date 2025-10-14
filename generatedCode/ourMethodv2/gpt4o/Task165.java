package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        Map<Character, Integer> suitCount = new HashMap<>();
        // Count suits on the table
        for (String card : table) {
            char suit = card.split("_")[1].charAt(0);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        // Count suits in hand
        for (String card : hand) {
            char suit = card.split("_")[1].charAt(0);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        // Check if there's a flush
        for (int count : suitCount.values()) {
            if (count >= 5) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, new String[]{"J_D", "3_D"})); // true
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, new String[]{"K_S", "Q_S"})); // true
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, new String[]{"3_S", "4_D"})); // false
        System.out.println(checkFlush(new String[]{"A_H", "J_H", "7_H", "8_H", "10_H"}, new String[]{"J_H", "3_H"})); // true
        System.out.println(checkFlush(new String[]{"2_C", "3_C", "4_C", "5_C", "6_C"}, new String[]{"7_C", "8_C"})); // true
    }
}