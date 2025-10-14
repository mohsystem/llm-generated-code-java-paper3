package Vanilla.claude;

import java.util.ArrayList;
import java.util.List;

class Task176 {
    private List<Integer> prefixProducts;
    
    public Task176() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) {
            return 0;
        }
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
    
    public static void main(String[] args) {
        // Test case 1: Example from problem
        Task176 test1 = new Task176();
        test1.add(3);
        test1.add(0);
        test1.add(2);
        test1.add(5);
        test1.add(4);
        System.out.println(test1.getProduct(2)); // Expected: 20
        System.out.println(test1.getProduct(3)); // Expected: 40
        System.out.println(test1.getProduct(4)); // Expected: 0
        test1.add(8);
        System.out.println(test1.getProduct(2)); // Expected: 32
        
        // Test case 2: All non-zero
        Task176 test2 = new Task176();
        test2.add(2);
        test2.add(3);
        test2.add(4);
        System.out.println(test2.getProduct(2)); // Expected: 12
        System.out.println(test2.getProduct(3)); // Expected: 24
        
        // Test case 3: Multiple zeros
        Task176 test3 = new Task176();
        test3.add(5);
        test3.add(0);
        test3.add(0);
        test3.add(6);
        System.out.println(test3.getProduct(1)); // Expected: 6
        
        // Test case 4: Single element
        Task176 test4 = new Task176();
        test4.add(7);
        System.out.println(test4.getProduct(1)); // Expected: 7
        
        // Test case 5: Zero then non-zero
        Task176 test5 = new Task176();
        test5.add(1);
        test5.add(2);
        test5.add(0);
        test5.add(3);
        test5.add(4);
        System.out.println(test5.getProduct(2)); // Expected: 12
        System.out.println(test5.getProduct(3)); // Expected: 0
    }
}
