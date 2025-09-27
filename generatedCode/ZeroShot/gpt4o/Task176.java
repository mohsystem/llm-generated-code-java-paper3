package ZeroShot.gpt4o;
import java.util.ArrayList;

class Task176 {
    static class ProductOfNumbers {
        private ArrayList<Integer> prefixProducts;

        public ProductOfNumbers() {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1); // Add a dummy 1 to handle prefix product calculation
        }

        public void add(int num) {
            if (num == 0) {
                prefixProducts.clear();
                prefixProducts.add(1); // Reset with a dummy 1
            } else {
                int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
                prefixProducts.add(lastProduct * num);
            }
        }

        public int getProduct(int k) {
            int n = prefixProducts.size();
            return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2)); // 20
        System.out.println(productOfNumbers.getProduct(3)); // 40
        System.out.println(productOfNumbers.getProduct(4)); // 0
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2)); // 32
    }
}