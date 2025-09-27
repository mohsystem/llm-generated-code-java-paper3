package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initialize with 1 for easier calculations
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        } else {
            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) {
            return 0; // Handles cases where k is larger than the current list size after zero is added.
        }
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
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

        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(3);
        productOfNumbers.add(4);
        productOfNumbers.add(5);
        System.out.println(productOfNumbers.getProduct(3)); // 60

    }
}