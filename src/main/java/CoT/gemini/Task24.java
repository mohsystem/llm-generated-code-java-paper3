package CoT.gemini;
class Task24 {
    public boolean validatePIN(String pin) {
        int len = pin.length();
        if (len != 4 && len != 6) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task24 task24 = new Task24();
        System.out.println(task24.validatePIN("1234")); // true
        System.out.println(task24.validatePIN("12345")); // false
        System.out.println(task24.validatePIN("a234")); // false
        System.out.println(task24.validatePIN("123456")); // true
        System.out.println(task24.validatePIN("1234a")); // false


    }
}