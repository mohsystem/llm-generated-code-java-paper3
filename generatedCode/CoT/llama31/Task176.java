package CoT.llama31;
public class Task176 {
    private int[] prefixProducts;
    private int size;

    public Task176() {
        prefixProducts = new int[40001];
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            size = 0;
            prefixProducts[0] = 1;
        } else {
            if (size == 0) {
                prefixProducts[0] = num;
            } else {
                prefixProducts[size] = prefixProducts[size - 1] * num;
            }
            size++;
        }
    }

    public int getProduct(int k) {
        if (size < k) {
            return 0;
        }
        if (size - k - 1 < 0) {
            return prefixProducts[size - 1];
        }
        return prefixProducts[size - 1] / prefixProducts[size - k - 1];
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