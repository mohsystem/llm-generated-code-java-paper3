package ZeroShot.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task176 {
    private List<Integer> prefixProducts;

    public Task176() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // to handle the case when k = 1
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k > prefixProducts.size() - 1) {
            return 0;
        } else {
            return prefixProducts.get(prefixProducts.size() - 1) / prefixProducts.get(prefixProducts.size() - k - 1);
        }
    }

    public static void main(String[] args) {
        Task176 productOfNumbers = new Task176();
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