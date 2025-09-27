package Vanilla.gemini;
class Task24 {
    public boolean validatePin(String pin) {
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
        Task24 task24 = new Task24();
        System.out.println(task24.validatePin("1234"));
        System.out.println(task24.validatePin("12345"));
        System.out.println(task24.validatePin("a234"));
        System.out.println(task24.validatePin("123456"));
        System.out.println(task24.validatePin("123a"));
    }
}