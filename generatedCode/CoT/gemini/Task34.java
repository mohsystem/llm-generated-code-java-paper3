package CoT.gemini;
class Task34 {
    public static boolean isNarcissistic(int number) {
        String numStr = String.valueOf(number);
        int power = numStr.length();
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(1)); // true
        System.out.println(isNarcissistic(407)); // true
        System.out.println(isNarcissistic(1634)); // true

    }
}