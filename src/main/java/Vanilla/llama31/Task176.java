package Vanilla.llama31;
public class Task176 {
    public static class ProductOfNumbers {
        private java.util.List<Integer> prefixProducts;

        public ProductOfNumbers() {
            prefixProducts = new java.util.ArrayList<>();
            prefixProducts.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixProducts.clear();
                prefixProducts.add(1);
            } else {
                if (prefixProducts.size() == 0) {
                    prefixProducts.add(num);
                } else {
                    prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
                }
            }
        }

        public int getProduct(int k) {
            int size = prefixProducts.size();
            if (size <= k) {
                return 0;
            } else {
                return prefixProducts.get(size - 1) / prefixProducts.get(size - k - 1);
            }
        }
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32
    }
}