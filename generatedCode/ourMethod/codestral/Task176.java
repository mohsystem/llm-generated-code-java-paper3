package ourMethod.codestral;
import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = products.size();
        if (k >= n) {
            return 0;
        }
        return products.get(n - 1) / products.get(n - k - 1);
    }

    public static void main(String[] args) {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(3);
        pn.add(0);
        pn.add(2);
        pn.add(5);
        pn.add(4);
        System.out.println(pn.getProduct(2)); // 20
        System.out.println(pn.getProduct(3)); // 40
        System.out.println(pn.getProduct(4)); // 0
        pn.add(8);
        System.out.println(pn.getProduct(2)); // 32
    }
}