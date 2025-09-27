package ourMethod.gemini;
class Task5 {
    public static int persistence(long n) {
        int count = 0;
        while (n >= 10) {
            long product = 1;
            while (n > 0) {
                product *= n % 10;
                n /= 10;
            }
            n = product;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));  // Output: 3
        System.out.println(persistence(999)); // Output: 4
        System.out.println(persistence(4));   // Output: 0
        System.out.println(persistence(25));  // Output: 2
        System.out.println(persistence(77));  // Output: 2

    }
}