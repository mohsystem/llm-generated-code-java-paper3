package ourMethod.claude;

import java.util.ArrayList;
import java.util.List;

class Task176 {
    private List<Integer> prefixProducts;
    
    public Task176() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // sentinel value
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
            return;
        }
        
        prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) return 0;
        return prefixProducts.get(n-1) / prefixProducts.get(n-k-1);
    }

    public static void main(String[] args) {
        // Test case 1
        Task176 t1 = new Task176();
        t1.add(3);
        t1.add(0);
        t1.add(2);
        t1.add(5);
        t1.add(4);
        System.out.println(t1.getProduct(2)); // Expected: 20

        // Test case 2  
        Task176 t2 = new Task176();
        t2.add(2);
        t2.add(3);
        t2.add(4);
        System.out.println(t2.getProduct(3)); // Expected: 24

        // Test case 3
        Task176 t3 = new Task176();
        t3.add(1);
        t3.add(2);
        t3.add(3);
        t3.add(0);
        System.out.println(t3.getProduct(2)); // Expected: 0

        // Test case 4
        Task176 t4 = new Task176();
        t4.add(5);
        t4.add(2);
        t4.add(4);
        t4.add(8);
        System.out.println(t4.getProduct(2)); // Expected: 32

        // Test case 5
        Task176 t5 = new Task176();
        t5.add(3);
        t5.add(6);
        t5.add(0);
        t5.add(2);
        t5.add(4);
        System.out.println(t5.getProduct(3)); // Expected: 0
    }
}
