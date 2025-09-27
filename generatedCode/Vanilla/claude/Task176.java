package Vanilla.claude;

class Task176 {
    static class ProductOfNumbers {
        private List<Integer> prefix;
        
        public ProductOfNumbers() {
            prefix = new ArrayList<>();
            prefix.add(1); // Sentinel value
        }
        
        public void add(int num) {
            if (num == 0) {
                prefix = new ArrayList<>();
                prefix.add(1);
            } else {
                prefix.add(prefix.get(prefix.size() - 1) * num);
            }
        }
        
        public int getProduct(int k) {
            int n = prefix.size();
            if (k >= n) return 0;
            return prefix.get(n-1) / prefix.get(n-k-1);
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers pn = new ProductOfNumbers();
        
        // Test case 1
        pn.add(3);
        pn.add(0);
        pn.add(2);
        pn.add(5);
        pn.add(4);
        System.out.println(pn.getProduct(2)); // 20
        
        // Test case 2
        ProductOfNumbers pn2 = new ProductOfNumbers();
        pn2.add(2);
        pn2.add(3);
        pn2.add(4);
        System.out.println(pn2.getProduct(3)); // 24
        
        // Test case 3
        ProductOfNumbers pn3 = new ProductOfNumbers();
        pn3.add(1);
        pn3.add(1);
        pn3.add(1);
        System.out.println(pn3.getProduct(2)); // 1
        
        // Test case 4
        ProductOfNumbers pn4 = new ProductOfNumbers();
        pn4.add(5);
        pn4.add(0);
        pn4.add(2);
        System.out.println(pn4.getProduct(2)); // 0
        
        // Test case 5
        ProductOfNumbers pn5 = new ProductOfNumbers();
        pn5.add(2);
        pn5.add(5);
        pn5.add(3);
        pn5.add(4);
        System.out.println(pn5.getProduct(4)); // 120
    }
}
