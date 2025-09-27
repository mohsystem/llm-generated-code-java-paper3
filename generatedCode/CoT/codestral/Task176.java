package CoT.codestral;
import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k >= products.size()) return 0;
        return products.get(products.size() - 1) / products.get(products.size() - k - 1);
    }
}