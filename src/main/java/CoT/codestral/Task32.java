package CoT.codestral;
public class Task32 {
    public static int yearsToDesiredSum(double P, double I, double T, double D) {
        int Y = 0;
        while (P < D) {
            double interest = P * I;
            double tax = interest * T;
            P = P + interest - tax;
            Y++;
        }
        return Y;
    }

    public static void main(String[] args) {
        System.out.println(yearsToDesiredSum(1000.00, 0.05, 0.18, 1100.00)); // Outputs: 3
    }
}