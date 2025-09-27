package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task165 {
    public static boolean checkFlush(String[] tableCards, String[] handCards) {
        Map<Character, Integer> suitCount = new HashMap<>();
        
        for (String card : tableCards) {
            char suit = card.split("_")[1].charAt(0);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        
        for (String card : handCards) {
            char suit = card.split("_")[1].charAt(0);
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        
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
        System.out.println(checkFlush(new String[]{"2_H", "3_H", "4_H", "5_H", "9_D"}, new String[]{"6_H", "7_C"})); // true
        System.out.println(checkFlush(new String[]{"2_D", "3_D", "4_H", "5_C", "9_D"}, new String[]{"6_D", "7_D"})); // true
    }
}