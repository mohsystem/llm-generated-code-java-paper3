package ZeroShot.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        Set<Character> suits = new HashSet<>();
        for (String card : table) {
            suits.add(card.charAt(2));
        }
        for (String card : hand) {
            suits.add(card.charAt(2));
        }
        for (char suit : suits) {
            int count = 0;
            for (String card : table) {
                if (card.charAt(2) == suit) {
                    count++;
                }
            }
            for (String card : hand) {
                if (card.charAt(2) == suit) {
                    count++;
                }
            }
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
    }
}