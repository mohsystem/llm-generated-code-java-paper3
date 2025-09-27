package ZeroShot.claude;

import java.util.ArrayList;

class Task176 {
    private ArrayList<Integer> prefix;

    public Task176() {
        prefix = new ArrayList<>();
        prefix.add(1); // Start with 1 as initial prefix product
    }
    
    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        if (k > n-1) return 0;
        return prefix.get(n-1) / prefix.get(n-k-1);
    }

    public static void main(String[] args) {
        // Test case 1
        Task176 p1 = new Task176();
        p1.add(3);
        p1.add(0);
        p1.add(2);
        System.out.println(p1.getProduct(2)); // Should print 0

        // Test case 2
        Task176 p2 = new Task176();
        p2.add(2);
        p2.add(3);
        p2.add(4);
        System.out.println(p2.getProduct(3)); // Should print 24

        // Test case 3
        Task176 p3 = new Task176();
        p3.add(5);
        p3.add(2);
        System.out.println(p3.getProduct(2)); // Should print 10

        // Test case 4
        Task176 p4 = new Task176();
        p4.add(3);
        p4.add(1);
        p4.add(2);
        p4.add(5);
        p4.add(4);
        System.out.println(p4.getProduct(2)); // Should print 20

        // Test case 5
        Task176 p5 = new Task176();
        p5.add(1);
        p5.add(1);
        p5.add(1);
        System.out.println(p5.getProduct(3)); // Should print 1
    }
}
