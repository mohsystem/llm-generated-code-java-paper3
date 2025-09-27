package Vanilla.claude;

class Task198 {
    public int rand7() {
        // Simulated rand7() API
        return (int)(Math.random() * 7) + 1;
    }
    
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }
    
    public static void main(String[] args) {
        Task198 solution = new Task198();
        // Test case 1: n = 1
        System.out.println(solution.rand10());
        
        // Test case 2: n = 2
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        
        // Test case 3: n = 3
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        
        // Test case 4: n = 4
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        
        // Test case 5: n = 5
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
    }
}
