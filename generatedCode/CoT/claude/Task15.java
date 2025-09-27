package CoT.claude;

public class Task15 {
    public static String[] buildTower(int floors) {
        if (floors <= 0) return new String[0];
        
        String[] tower = new String[floors];
        int width = 2 * floors - 1;
        
        for (int i = 0; i < floors; i++) {
            StringBuilder floor = new StringBuilder();
            int stars = 2 * i + 1;
            int spaces = (width - stars) / 2;
            
            floor.append(" ".repeat(spaces));
            floor.append("*".repeat(stars));
            floor.append(" ".repeat(spaces));
            
            tower[i] = floor.toString();
        }
        return tower;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 3, 4, 6};
        
        for(int floors : testCases) {
            System.out.println("Tower with " + floors + " floors:");
            String[] tower = buildTower(floors);
            for(String floor : tower) {
                System.out.println(floor);
            }
            System.out.println();
        }
    }
}
