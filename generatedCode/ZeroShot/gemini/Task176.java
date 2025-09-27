package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(list.get(list.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = list.size();
        if (k >= n) {
            return 0;
        }
        return list.get(n - 1) / list.get(n - 1 - k);
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32 
        
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        System.out.println(productOfNumbers.getProduct(1));

        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(7);
        productOfNumbers.add(4);
        productOfNumbers.add(10);
        productOfNumbers.add(1);
        System.out.println(productOfNumbers.getProduct(1));
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));

        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(10);
        productOfNumbers.add(5);
        productOfNumbers.add(7);
        productOfNumbers.add(2);
        productOfNumbers.add(1);
        System.out.println(productOfNumbers.getProduct(1));
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        System.out.println(productOfNumbers.getProduct(5));

        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(5);
        productOfNumbers.add(5);
        productOfNumbers.add(6);
        productOfNumbers.add(6);
        productOfNumbers.add(10);
        System.out.println(productOfNumbers.getProduct(1));
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        System.out.println(productOfNumbers.getProduct(5));
    }
}