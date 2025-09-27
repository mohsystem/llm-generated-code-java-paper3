package ourMethod.llama31;
import java.util.*;

public class Task176 {
    private List<Integer> prefixProducts;
    private List<Integer> zeroIndices;

    public Task176() {
        prefixProducts = new ArrayList<>();
        zeroIndices = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            zeroIndices.add(prefixProducts.size());
            prefixProducts.add(1);
        } else {
            if (prefixProducts.isEmpty()) {
                prefixProducts.add(num);
            } else {
                prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
            }
        }
    }

    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k > size) {
            return 0; // This should not happen based on the problem constraints
        }

        int lastIndex = size - k;
        if (zeroIndices.contains(lastIndex)) {
            return 0;
        }

        if (lastIndex == 0) {
            return prefixProducts.get(size - 1);
        }

        return prefixProducts.get(size - 1) / prefixProducts.get(lastIndex - 1);
    }

    public static void main(String[] args) {
        Task176 productOfNumbers = new Task176();
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
    }
}