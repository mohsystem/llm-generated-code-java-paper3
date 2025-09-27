package Vanilla.codestral;
public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        int[] suits = new int[4];
        for (String card : table) {
            char suit = card.charAt(card.length() - 1);
            switch (suit) {
                case 'S':
                    suits[0]++;
                    break;
                case 'H':
                    suits[1]++;
                    break;
                case 'D':
                    suits[2]++;
                    break;
                case 'C':
                    suits[3]++;
                    break;
            }
        }
        for (String card : hand) {
            char suit = card.charAt(card.length() - 1);
            switch (suit) {
                case 'S':
                    suits[0]++;
                    break;
                case 'H':
                    suits[1]++;
                    break;
                case 'D':
                    suits[2]++;
                    break;
                case 'C':
                    suits[3]++;
                    break;
            }
        }
        for (int suit : suits) {
            if (suit >= 5) {
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