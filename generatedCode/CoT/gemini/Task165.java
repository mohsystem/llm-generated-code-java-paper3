package CoT.gemini;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task165 {

    public static boolean checkFlush(String[] table, String[] hand) {
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
        List<String[]> tableList = Arrays.asList(
                new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"},
                new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"},
                new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"},
                new String[]{"2_H", "5_H", "A_H", "K_H", "J_H"},
                new String[]{"2_H", "5_D", "A_H", "K_C", "J_H"}
        );

        List<String[]> handList = Arrays.asList(
                new String[]{"J_D", "3_D"},
                new String[]{"K_S", "Q_S"},
                new String[]{"3_S", "4_D"},
                new String[]{"10_H", "Q_H"},
                new String[]{"10_S", "Q_S"}
        );

        for (int i = 0; i < tableList.size(); i++) {
            System.out.println(checkFlush(tableList.get(i), handList.get(i)));
        }


    }
}