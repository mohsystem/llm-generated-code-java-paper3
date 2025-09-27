package CoT.claude;

class Task198 {
    public int rand7() {
        // API provided, implementation not shown
        return (int)(Math.random() * 7) + 1;
    }
    
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = (rand7() - 1) * 7 + (rand7() - 1);
        }
        return result % 10 + 1;
    }
    
    public static void main(String[] args) {
        Task198 solution = new Task198();
        
        // Test case 1: n = 1
        System.out.print("n = 1: [");
        System.out.print(solution.rand10());
        System.out.println("]");
        
        // Test case 2: n = 2
        System.out.print("n = 2: [");
        System.out.print(solution.rand10() + "," + solution.rand10());
        System.out.println("]");
        
        // Test case 3: n = 3
        System.out.print("n = 3: [");
        System.out.print(solution.rand10() + "," + solution.rand10() + "," + solution.rand10());
        System.out.println("]");
        
        // Test case 4: n = 4
        System.out.print("n = 4: [");
        System.out.print(solution.rand10() + "," + solution.rand10() + "," + 
                        solution.rand10() + "," + solution.rand10());
        System.out.println("]");
        
        // Test case 5: n = 5
        System.out.print("n = 5: [");
        System.out.print(solution.rand10() + "," + solution.rand10() + "," + 
                        solution.rand10() + "," + solution.rand10() + "," + solution.rand10());
        System.out.println("]");
    }
}
