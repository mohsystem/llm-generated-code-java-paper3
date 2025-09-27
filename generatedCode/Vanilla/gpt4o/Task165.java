package Vanilla.gpt4o;
public class Task165 {

    public static boolean checkFlush(String[] table, String[] hand) {
        int[] suitCount = new int[4]; // Indexes: 0 - Spades, 1 - Hearts, 2 - Diamonds, 3 - Clubs

        for (String card : table) {
            switch (card.split("_")[1]) {
                case "S":
                    suitCount[0]++;
                    break;
                case "H":
                    suitCount[1]++;
                    break;
                case "D":
                    suitCount[2]++;
                    break;
                case "C":
                    suitCount[3]++;
                    break;
            }
        }

        for (String card : hand) {
            switch (card.split("_")[1]) {
                case "S":
                    suitCount[0]++;
                    break;
                case "H":
                    suitCount[1]++;
                    break;
                case "D":
                    suitCount[2]++;
                    break;
                case "C":
                    suitCount[3]++;
                    break;
            }
        }

        for (int count : suitCount) {
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
        System.out.println(checkFlush(new String[]{"2_H", "3_H", "4_H", "5_H", "6_D"}, new String[]{"7_H", "8_C"})); // true
        System.out.println(checkFlush(new String[]{"2_D", "4_S", "5_C", "8_D", "K_H"}, new String[]{"Q_H", "3_D"})); // false
    }
}