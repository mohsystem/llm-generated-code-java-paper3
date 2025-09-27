package ZeroShot.llama31;
public class Task44 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(validateInput("1234", "integer")); // Valid integer
        System.out.println(validateInput("abcd", "integer")); // Invalid integer
        System.out.println(validateInput("25", "age")); // Valid age
        System.out.println(validateInput("150", "age")); // Invalid age
        System.out.println(validateInput("abcd@gmail.com", "email")); // Valid email
    }

    public static String validateInput(String input, String type) {
        if (type.equals("integer")) {
            try {
                int number = Integer.parseInt(input);
                return "Valid integer: " + number;
            } catch (NumberFormatException e) {
                return "Invalid input. Please enter an integer.";
            }
        } else if (type.equals("age")) {
            try {
                int age = Integer.parseInt(input);
                if (age >= 1 && age <= 120) {
                    return "Valid age: " + age;
                } else {
                    return "Invalid age. Please enter an age between 1 and 120.";
                }
            } catch (NumberFormatException e) {
                return "Invalid input. Please enter an integer.";
            }
        } else if (type.equals("email")) {
            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (input.matches(emailPattern)) {
                return "Valid email: " + input;
            } else {
                return "Invalid email format.";
            }
        }
        return "Invalid type.";
    }
}