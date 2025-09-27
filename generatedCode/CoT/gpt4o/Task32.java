package CoT.gpt4o;
public class Task32 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            double accruedInterest = principal * interest;
            double taxedInterest = accruedInterest * (1 - tax);
            principal += taxedInterest;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1100.0)); // 3
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1200.0)); // 6
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1500.0)); // 15
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1000.0)); // 0
        System.out.println(calculateYears(1000.0, 0.1, 0.18, 1100.0)); // 1
    }
}