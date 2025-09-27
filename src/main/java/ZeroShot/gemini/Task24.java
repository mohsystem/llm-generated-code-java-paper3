package ZeroShot.gemini;
class Task24 {
    public boolean validatePIN(String pin) {
        if (pin.length() != 4 && pin.length() != 6) {
            return false;
        }
        for (char c : pin.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task24 task = new Task24();
        System.out.println(task.validatePIN("1234")); // true
        System.out.println(task.validatePIN("12345")); // false
        System.out.println(task.validatePIN("a234")); // false
        System.out.println(task.validatePIN("123456")); // true
        System.out.println(task.validatePIN("1234a")); // false


    }
}