package Vanilla.codestral;
public class Task124 {
    private static final byte ENCRYPTION_KEY = 0x5;

    public static void main(String[] args) {
        String creditCardNumber = "1234567890123456";
        String encryptedCreditCardNumber = encrypt(creditCardNumber);
        System.out.println("Encrypted Credit Card Number: " + encryptedCreditCardNumber);
    }

    public static String encrypt(String data) {
        byte[] encryptedData = new byte[data.length()];
        for (int i = 0; i < data.length(); i++) {
            encryptedData[i] = (byte) (data.charAt(i) ^ ENCRYPTION_KEY);
        }
        return new String(encryptedData);
    }
}