package ourMethod.codestral;
public class Task32 {
    public static int yearsToDesiredSum(double P, double I, double T, double D) {
        int years = 0;
        while (P < D) {
            double interest = P * I;
            double tax = interest * T;
            P += (interest - tax);
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(yearsToDesiredSum(1000.00, 0.05, 0.18, 1100.00));  // Output: 3
        System.out.println(yearsToDesiredSum(2000.00, 0.03, 0.15, 2100.00));  // Output: 2
        System.out.println(yearsToDesiredSum(500.00, 0.08, 0.20, 500.00));    // Output: 0
        System.out.println(yearsToDesiredSum(10000.00, 0.02, 0.10, 10500.00));  // Output: 10
        System.out.println(yearsToDesiredSum(2500.00, 0.07, 0.15, 3000.00));  // Output: 5
    }
}