package CoT.claude;

class Task176 {
    private List<Integer> prefixProducts;
    
    public Task176() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initialize with 1 for easier calculation
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
        if (k > n - 1) return 0;
        return prefixProducts.get(n-1) / prefixProducts.get(n-k-1);
    }

    public static void main(String[] args) {
        Task176 prod = new Task176();
        
        // Test case 1
        prod.add(3);
        prod.add(0);
        prod.add(2);
        prod.add(5);
        prod.add(4);
        System.out.println(prod.getProduct(2)); // Should print 20
        
        // Test case 2
        Task176 prod2 = new Task176();
        prod2.add(2);
        prod2.add(3);
        prod2.add(4);
        System.out.println(prod2.getProduct(3)); // Should print 24
        
        // Test case 3
        Task176 prod3 = new Task176();
        prod3.add(1);
        prod3.add(1);
        prod3.add(1);
        System.out.println(prod3.getProduct(2)); // Should print 1
        
        // Test case 4
        Task176 prod4 = new Task176();
        prod4.add(10);
        prod4.add(0);
        prod4.add(2);
        System.out.println(prod4.getProduct(2)); // Should print 0
        
        // Test case 5
        Task176 prod5 = new Task176();
        prod5.add(5);
        prod5.add(2);
        prod5.add(4);
        prod5.add(3);
        System.out.println(prod5.getProduct(3)); // Should print 24
    }
}
