package CoT.codestral;
class Task115 {
    private int bitField;

    // Set bit at position pos to 1
    public void setBit(int pos) {
        bitField |= (1 << pos);
    }

    // Set bit at position pos to 0
    public void clearBit(int pos) {
        bitField &= ~(1 << pos);
    }

    // Get the bit at position pos
    public int getBit(int pos) {
        return (bitField & (1 << pos)) != 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Task115 bitField = new Task115();
        bitField.setBit(3);
        System.out.println(bitField.getBit(3)); // prints 1
        bitField.clearBit(3);
        System.out.println(bitField.getBit(3)); // prints 0
    }
}