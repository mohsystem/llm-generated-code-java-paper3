package ourMethod.claude;

public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        if (table == null || hand == null || table.length != 5 || hand.length != 2) {
            return false;
        }
        
        int[] suitCount = new int[4]; // S, H, D, C
        
        // Count suits on table
        for (String card : table) {
            if (card == null || !card.contains("_")) continue;
            char suit = card.charAt(card.length()-1);
            switch(suit) {
                case 'S': suitCount[0]++; break;
                case 'H': suitCount[1]++; break; 
                case 'D': suitCount[2]++; break;
                case 'C': suitCount[3]++; break;
            }
        }
        
        // Add hand suits
        for (String card : hand) {
            if (card == null || !card.contains("_")) continue;
            char suit = card.charAt(card.length()-1);
            switch(suit) {
                case 'S': suitCount[0]++; break;
                case 'H': suitCount[1]++; break;
                case 'D': suitCount[2]++; break;
                case 'C': suitCount[3]++; break;
            }
        }
        
        // Check for flush (5 or more of same suit)
        for (int count : suitCount) {
            if (count >= 5) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, 
                                    new String[]{"J_D", "3_D"})); // true
        
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"},
                                    new String[]{"K_S", "Q_S"})); // true
        
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"},
                                    new String[]{"3_S", "4_D"})); // false
                                    
        System.out.println(checkFlush(new String[]{"A_H", "K_H", "Q_H", "J_H", "10_H"},
                                    new String[]{"2_H", "3_H"})); // true
                                    
        System.out.println(checkFlush(new String[]{"A_C", "K_C", "Q_C", "J_C", "10_S"},
                                    new String[]{"2_C", "3_H"})); // false
    }
}
