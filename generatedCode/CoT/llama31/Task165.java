package CoT.llama31;
public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        String[] suits = {"S", "H", "D", "C"};
        int[] suitCounts = new int[4];

        // Count suits from table
        for (String card : table) {
            for (int i = 0; i < suits.length; i++) {
                if (card.endsWith(suits[i])) {
                    suitCounts[i]++;
                    break;
                }
            }
        }

        // Count suits from hand
        for (String card : hand) {
            for (int i = 0; i < suits.length; i++) {
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
        String[][] testTables = {
            {"A_S", "J_H", "7_D", "8_D", "10_D"},
            {"10_S", "7_S", "9_H", "4_S", "3_S"},
            {"3_S", "10_H", "10_D", "10_C", "10_S"},
            {"K_S", "Q_S", "J_S", "10_S", "9_S"},
            {"A_H", "K_H", "Q_H", "J_H", "10_H"}
        };

        String[][] testHands = {
            {"J_D", "3_D"},
            {"K_S", "Q_S"},
            {"3_S", "4_D"},
            {"8_S", "7_S"},
            {"9_H", "8_H"}
        };

        for (int i = 0; i < testTables.length; i++) {
            System.out.println("Table: " + java.util.Arrays.toString(testTables[i]) + ", Hand: " + java.util.Arrays.toString(testHands[i]) + " -> " + checkFlush(testTables[i], testHands[i]));
        }
    }
}