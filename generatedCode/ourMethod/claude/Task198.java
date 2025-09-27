package ourMethod.claude;

public class Task198 {
    // API provided by the problem
    private int rand7() {
        return (int)(Math.random() * 7) + 1;
    }
    
    public int rand10() {
        int result = 0;
        while (true) {
            // Generate a number in range [1, 49]
            result = (rand7() - 1) * 7 + rand7();
            // If result > 40, reject and try again
            if (result <= 40) {
                return result % 10 + 1;
            }
        }
    }
    
    public static void main(String[] args) {
        Task198 solution = new Task198();
        
        // Test case 1: n = 1
        System.out.print("Test case 1: ");
        System.out.println(solution.rand10());
        
        // Test case 2: n = 2
        System.out.print("Test case 2: ");
        for (int i = 0; i < 2; i++) {
            System.out.print(solution.rand10() + " ");
        }
        System.out.println();
        
        // Test case 3: n = 3
        System.out.print("Test case 3: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(solution.rand10() + " ");
        }
        System.out.println();
        
        // Test case 4: n = 5
        System.out.print("Test case 4: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(solution.rand10() + " ");
        }
        System.out.println();
        
        // Test case 5: n = 10
        System.out.print("Test case 5: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(solution.rand10() + " ");
        }
        System.out.println();
    }
}
