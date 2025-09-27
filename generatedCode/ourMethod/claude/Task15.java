package ourMethod.claude;

public class Task15 {
    public static String[] towerBuilder(int nFloors) {
        if (nFloors <= 0) {
            return new String[0];
        }
        
        String[] tower = new String[nFloors];
        int maxWidth = 2 * nFloors - 1;
        
        for (int i = 0; i < nFloors; i++) {
            int stars = 2 * i + 1;
            int spaces = (maxWidth - stars) / 2;
            
            StringBuilder floor = new StringBuilder();
            for (int j = 0; j < spaces; j++) {
                floor.append(' ');
            }
            for (int j = 0; j < stars; j++) {
                floor.append('*');
            }
            for (int j = 0; j < spaces; j++) {
                floor.append(' ');
            }
            
            tower[i] = floor.toString();
        }
        
        return tower;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] tests = {1, 2, 3, 4, 6};
        for (int test : tests) {
            System.out.println("Tower with " + test + " floors:");
            String[] tower = towerBuilder(test);
            for (String floor : tower) {
                System.out.println(floor);
            }
            System.out.println();
        }
    }
}
