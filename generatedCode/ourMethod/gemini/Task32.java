package ourMethod.gemini;
class Task32 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            principal += principal * interest * (1 - tax);
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1100.0)); // 3
        System.out.println(calculateYears(1000.0, 0.01625, 0.18, 1200.0)); // 14
        System.out.println(calculateYears(1000.0, 0.05, 0.18, 1000.0)); // 0
        System.out.println(calculateYears(1500.0, 0.045, 0.18, 2000.0)); // 8
        System.out.println(calculateYears(1000.0, 0.10, 0.0, 2000)); //7

    }
}