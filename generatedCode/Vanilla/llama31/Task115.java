package Vanilla.llama31;
public class Task115 {
    public static class BitFields {
        private int bits;

        public void setBit0(boolean value) {
            bits = (value ? bits | 1 : bits & ~1);
        }

        public void setBit1to3(int value) {
            bits = (bits & ~0xE) | (value << 1);
        }

        public void setBit4(boolean value) {
            bits = (value ? bits | 0x10 : bits & ~0x10);
        }

        public void setBit5(boolean value) {
            bits = (value ? bits | 0x20 : bits & ~0x20);
        }

        public void setBit6to7(int value) {
            bits = (bits & ~0xC0) | (value << 6);
        }

        public int getBit0() {
            return (bits & 1) != 0 ? 1 : 0;
        }

        public int getBit1to3() {
            return (bits >> 1) & 0x7;
        }

        public int getBit4() {
            return (bits & 0x10) != 0 ? 1 : 0;
        }

        public int getBit5() {
            return (bits & 0x20) != 0 ? 1 : 0;
        }

        public int getBit6to7() {
            return (bits >> 6) & 0x3;
        }
    }

    public static void main(String[] args) {
        BitFields bitFields = new BitFields();
        bitFields.setBit0(true);
        bitFields.setBit1to3(5);
        bitFields.setBit4(true);
        bitFields.setBit5(false);
        bitFields.setBit6to7(2);

        System.out.println("Bit 0: " + bitFields.getBit0());
        System.out.println("Bits 1-3: " + bitFields.getBit1to3());
        System.out.println("Bit 4: " + bitFields.getBit4());
        System.out.println("Bit 5: " + bitFields.getBit5());
        System.out.println("Bits 6-7: " + bitFields.getBit6to7());
    }
}