package ourMethod.llama31;
public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        String[] suits = {"S", "H", "D", "C"};
        int[] suitCounts = new int[4];

        // Count suits on the table
        for (String card : table) {
            for (int i = 0; i < 4; i++) {
                if (card.endsWith(suits[i])) {
                    suitCounts[i]++;
                    break;
                }
            }
        }

        // Count suits in the hand
        for (String card : hand) {
            for (int i = 0; i < 4; i++) {
                if (card.endsWith(suits[i])) {
                    suitCounts[i]++;
                    break;
                }
            }
        }

        // Check if any suit has at least 5 cards
        for (int count : suitCounts) {
            if (count >= 5) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, new String[]{"J_D", "3_D"})); // true
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, new String[]{"K_S", "Q_S"})); // true
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, new String[]{"3_S", "4_D"})); // false
    }
}