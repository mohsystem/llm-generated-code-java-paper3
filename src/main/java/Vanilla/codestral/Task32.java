package Vanilla.codestral;
public class Task32 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            double interestEarned = principal * interest;
            double taxPaid = interestEarned * tax;
            principal += interestEarned - taxPaid;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1100.00)); // 3
        System.out.println(calculateYears(1000.00, 0.01625, 0.18, 1200.00)); // 14
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1000.00)); // 0
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1110.00)); // 4
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1150.00)); // 5
    }
}