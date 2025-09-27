package ourMethod.llama31;
public class Task124 {
    public static void main(String[] args) {
        // Example usage
        SensitiveData data = new SensitiveData("John Doe", "1234-5678-9012-3456", "123");
        data.printData();
    }

    public static class SensitiveData {
        private String name;
        private String creditCardNumber;
        private String securityCode;

        public SensitiveData(String name, String creditCardNumber, String securityCode) {
            this.name = name;
            this.creditCardNumber = creditCardNumber;
            this.securityCode = securityCode;
        }

        public void printData() {
            System.out.println("Name: " + name);
            System.out.println("Credit Card Number: " + maskCreditCardNumber(creditCardNumber));
            System.out.println("Security Code: " + maskSecurityCode(securityCode));
        }

        private String maskCreditCardNumber(String creditCardNumber) {
            return "XXXX-XXXX-XXXX-" + creditCardNumber.substring(creditCardNumber.length() - 4);
        }

        private String maskSecurityCode(String securityCode) {
            return "XXX-" + securityCode.substring(securityCode.length() - 1);
        }
    }
}