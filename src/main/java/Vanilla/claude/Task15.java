package Vanilla.claude;

public class Task15 {
    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        int width = 2 * floors - 1;
        
        for(int i = 0; i < floors; i++) {
            int stars = 2 * i + 1;
            int spaces = (width - stars) / 2;
            tower[i] = " ".repeat(spaces) + "*".repeat(stars) + " ".repeat(spaces);
        }
        return tower;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] tests = {1, 2, 3, 4, 6};
        
        for(int test : tests) {
            System.out.println("Tower with " + test + " floors:");
            String[] tower = buildTower(test);
            for(String floor : tower) {
                System.out.println(floor);
            }
            System.out.println();
        }
    }
}
