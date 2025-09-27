package CoT.gemini;
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
            return 0; // Handles cases where k is larger than the current list size and there's a zero earlier
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
        System.out.println(productOfNumbers.getProduct(2)); // Output: 20
        System.out.println(productOfNumbers.getProduct(3)); // Output: 40
        System.out.println(productOfNumbers.getProduct(4)); // Output: 0
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2)); // Output: 32


        ProductOfNumbers productOfNumbers2 = new ProductOfNumbers();
        productOfNumbers2.add(1);
        productOfNumbers2.add(2);
        productOfNumbers2.add(3);
        productOfNumbers2.add(4);
        productOfNumbers2.add(5);
        System.out.println(productOfNumbers2.getProduct(2));
        System.out.println(productOfNumbers2.getProduct(3));
        System.out.println(productOfNumbers2.getProduct(4));
        productOfNumbers2.add(0);
        productOfNumbers2.add(2);
        productOfNumbers2.add(2);
        System.out.println(productOfNumbers2.getProduct(2)); // 4
        System.out.println(productOfNumbers2.getProduct(3)); // 8
        System.out.println(productOfNumbers2.getProduct(4)); // 0



    }
}