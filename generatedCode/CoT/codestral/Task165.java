package CoT.codestral;
public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        int spades = 0, hearts = 0, diamonds = 0, clubs = 0;

        for (String card : table) {
            if (card.endsWith("_S")) spades++;
            else if (card.endsWith("_H")) hearts++;
            else if (card.endsWith("_D")) diamonds++;
            else if (card.endsWith("_C")) clubs++;
        }

        for (String card : hand) {
            if (card.endsWith("_S")) spades++;
            else if (card.endsWith("_H")) hearts++;
            else if (card.endsWith("_D")) diamonds++;
            else if (card.endsWith("_C")) clubs++;
        }

        return spades >= 5 || hearts >= 5 || diamonds >= 5 || clubs >= 5;
    }

    public static void main(String[] args) {
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, new String[]{"J_D", "3_D"})); // true
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, new String[]{"K_S", "Q_S"})); // true
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, new String[]{"3_S", "4_D"})); // false
    }
}