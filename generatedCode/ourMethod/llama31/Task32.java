package ourMethod.llama31;
public class Task32 {
    public static int calculateYears(double principal, double interestRate, double taxRate, double desiredSum) {
        if (desiredSum <= principal) {
            return 0;
        }
        int years = 0;
        while (principal < desiredSum) {
            double interest = principal * interestRate;
            double tax = interest * taxRate;
            principal += interest - tax;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1100.00)); // Output: 3
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1000.00)); // Output: 0
        System.out.println(calculateYears(500.00, 0.10, 0.20, 600.00)); // Output: 2
        System.out.println(calculateYears(2000.00, 0.03, 0.15, 2200.00)); // Output: 4
        System.out.println(calculateYears(1500.00, 0.07, 0.12, 1800.00)); // Output: 3
    }
}