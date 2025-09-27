package CoT.gemini;
import java.util.Scanner;

public class Task140 {

    public static double calculate(double num1, double num2, String operator) {
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                    return Double.NaN; // Indicate an error
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator");
                return Double.NaN; // Indicate an error

        }
        return result;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(calculate(5,2,"+"));
        System.out.println(calculate(5,2,"-"));
        System.out.println(calculate(5,2,"*"));
        System.out.println(calculate(5,2,"/"));
        System.out.println(calculate(5,0,"/"));


    }
}