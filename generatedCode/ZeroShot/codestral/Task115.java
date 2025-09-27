package ZeroShot.codestral;
public class Task115 {
    private static class BitFields {
        boolean bit1:1;
        boolean bit2:1;
        boolean bit3:3;
        boolean bit4:1;
    }

    public static void main(String[] args) {
        BitFields bitFields = new BitFields();
        // Test cases
        bitFields.bit1 = true;
        bitFields.bit2 = false;
        bitFields.bit3 = true;
        bitFields.bit4 = true;
        // More test cases can be added here
    }
}