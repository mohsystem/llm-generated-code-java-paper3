package Vanilla.llama31;
public class Task165 {
    public static boolean checkFlush(String[] tableCards, String[] handCards) {
        String[] suits = {"S", "H", "D", "C"};
        for (String suit : suits) {
            int count = 0;
            for (String card : tableCards) {
                if (card.endsWith(suit)) {
                    count++;
                }
            }
            for (String card : handCards) {
                if (card.endsWith(suit)) {
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
        System.out.println(checkFlush(new String[]{"A_H", "K_H", "Q_H", "J_H", "10_H"}, new String[]{"9_H", "8_H"})); // true
        System.out.println(checkFlush(new String[]{"2_C", "4_C", "6_C", "8_C", "10_C"}, new String[]{"3_C", "5_C"})); // true
    }
}