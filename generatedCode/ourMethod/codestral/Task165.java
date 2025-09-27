package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        Map<Character, Integer> suitCount = new HashMap<>();
        for (String card : table) {
            char suit = card.charAt(card.length() - 1);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 3) {
                return true;
            }
        }
        for (String card : hand) {
            char suit = card.charAt(card.length() - 1);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, new String[]{"J_D", "3_D"}));
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, new String[]{"K_S", "Q_S"}));
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, new String[]{"3_S", "4_D"}));
    }
}