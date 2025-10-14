package Vanilla.openai;
import java.util.*;

public class Task176 {

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

class ProductOfNumbers {
    List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        } else {
            int last = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(last * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
}