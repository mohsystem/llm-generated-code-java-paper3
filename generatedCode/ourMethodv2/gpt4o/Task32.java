package ourMethodv2.gpt4o;
public class Task32 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        if (principal >= desired) return 0;
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
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1000.0)); // 0
        System.out.println(calculateYears(1500.0, 0.03, 0.20, 2000.0)); // 14
        System.out.println(calculateYears(2000.0, 0.04, 0.15, 3000.0)); // 18
    }
}