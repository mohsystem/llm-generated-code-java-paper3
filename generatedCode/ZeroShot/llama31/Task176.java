package ZeroShot.llama31;
public class Task176 {
    static class ProductOfNumbers {
        private int[] prefix;
        private int idx;

        public ProductOfNumbers() {
            prefix = new int[40001];
            prefix[0] = 1;
            idx = 0;
        }

        public void add(int num) {
            if (num == 0) {
                idx = 0;
                prefix[0] = 1;
            } else {
                idx++;
                if (idx >= prefix.length) {
                    // Handle overflow, though it should not occur given the constraints
                    prefix = resize(prefix);
                }
                prefix[idx] = prefix[idx - 1] * num;
            }
        }

        public int getProduct(int k) {
            if (idx < k) return 0;
            if (prefix[idx - k + 1] == 0) return 0;
            return prefix[idx] / prefix[idx - k + 1];
        }

        private int[] resize(int[] array) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            return newArray;
        }
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
    }
}