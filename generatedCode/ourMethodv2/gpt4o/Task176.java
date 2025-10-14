package ourMethodv2.gpt4o;
public class Task176 {

    static class ProductOfNumbers {
        private ArrayList<Integer> prefixProducts;

        public ProductOfNumbers() {
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
            int size = prefixProducts.size();
            if (k >= size) return 0;
            int totalProduct = prefixProducts.get(size - 1);
            int excludedProduct = prefixProducts.get(size - k - 1);
            return totalProduct / excludedProduct;
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