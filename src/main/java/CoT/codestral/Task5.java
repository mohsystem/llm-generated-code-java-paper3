package CoT.codestral;
public class Task5 {
    public static int persistence(int num) {
        int count = 0;
        while (num >= 10) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39)); // Outputs: 3
        System.out.println(persistence(999)); // Outputs: 4
        System.out.println(persistence(4)); // Outputs: 0
    }
}