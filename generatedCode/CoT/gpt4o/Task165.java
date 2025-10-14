package CoT.openai;
import java.util.HashMap;
import java.util.Map;

public class Task165 {
    public static boolean checkFlush(String[] tableCards, String[] handCards) {
        Map<String, Integer> suitCount = new HashMap<>();
        for (String card : tableCards) {
            String suit = card.split("_")[1];
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        for (String card : handCards) {
            String suit = card.split("_")[1];
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
        System.out.println(checkFlush(new String[]{"2_H", "3_H", "4_H", "5_H", "6_H"}, new String[]{"7_H", "8_H"})); // true
        System.out.println(checkFlush(new String[]{"2_D", "3_C", "4_S", "5_S", "6_S"}, new String[]{"7_D", "8_D"})); // false
    }
}