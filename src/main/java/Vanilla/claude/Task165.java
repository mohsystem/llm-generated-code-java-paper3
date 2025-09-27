package Vanilla.claude;

public class Task165 {
    public static boolean checkFlush(String[] table, String[] hand) {
        int[] suitCount = new int[4]; // S, H, D, C
        
        // Count suits from table cards
        for(String card : table) {
            char suit = card.charAt(card.length()-1);
            switch(suit) {
                case 'S': suitCount[0]++; break;
                case 'H': suitCount[1]++; break;
                case 'D': suitCount[2]++; break;
                case 'C': suitCount[3]++; break;
            }
        }
        
        // Count suits from hand cards
        for(String card : hand) {
            char suit = card.charAt(card.length()-1);
            switch(suit) {
                case 'S': suitCount[0]++; break;
                case 'H': suitCount[1]++; break;
                case 'D': suitCount[2]++; break;
                case 'C': suitCount[3]++; break;
            }
        }
        
        // Check if any suit appears 5 or more times
        for(int count : suitCount) {
            if(count >= 5) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Test case 1
        System.out.println(checkFlush(new String[]{"A_S", "J_H", "7_D", "8_D", "10_D"}, 
                                    new String[]{"J_D", "3_D"})); // true
        
        // Test case 2                            
        System.out.println(checkFlush(new String[]{"10_S", "7_S", "9_H", "4_S", "3_S"}, 
                                    new String[]{"K_S", "Q_S"})); // true
                                    
        // Test case 3
        System.out.println(checkFlush(new String[]{"3_S", "10_H", "10_D", "10_C", "10_S"}, 
                                    new String[]{"3_S", "4_D"})); // false
                                    
        // Test case 4
        System.out.println(checkFlush(new String[]{"8_H", "10_H", "K_H", "Q_H", "J_H"}, 
                                    new String[]{"A_H", "2_H"})); // true
                                    
        // Test case 5
        System.out.println(checkFlush(new String[]{"8_C", "10_C", "K_C", "Q_C", "J_D"}, 
                                    new String[]{"A_C", "2_C"})); // true
    }
}
