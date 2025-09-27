package ourMethod.gemini;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task165 {
    public boolean checkFlush(String[] table, String[] hand) {
        Map<String, Integer> suitCounts = new HashMap<>();

        for (String card : table) {
            String suit = card.split("_")[1];
            suitCounts.put(suit, suitCounts.getOrDefault(suit, 0) + 1);
        }

        for (String card : hand) {
            String suit = card.split("_")[1];
            suitCounts.put(suit, suitCounts.getOrDefault(suit, 0) + 1);
        }


        for (int count : suitCounts.values()) {
            if (count >= 5) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Task165 task165 = new Task165();

        System.out.println(task165.checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, new String[]{"J_D", "3_D"})); // true
        System.out.println(task165.checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, new String[]{"K_S", "Q_S"})); // true
        System.out.println(task165.checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, new String[]{"3_S", "4_D"})); // false
        System.out.println(task165.checkFlush(new String[]{"2_H", "5_H", "A_H", "9_H", "J_H"}, new String[]{"2_D", "3_H"})); // true
        System.out.println(task165.checkFlush(new String[]{"K_C", "10_C", "8_C", "9_C", "J_C"}, new String[]{"Q_C", "A_C"})); // true

    }
}