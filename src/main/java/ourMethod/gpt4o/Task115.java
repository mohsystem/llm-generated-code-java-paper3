package ourMethod.gpt4o;
public class Task115 {
    static class BitFieldStruct {
        private int bitField1;
        private int bitField2;
        private int bitField3;
        
        public BitFieldStruct(int bitField1, int bitField2, int bitField3) {
            this.bitField1 = bitField1 & 0x1;  // 1 bit
            this.bitField2 = bitField2 & 0x7;  // 3 bits
            this.bitField3 = bitField3 & 0xF;  // 4 bits
        }

        public int getBitField1() {
            return bitField1;
        }

        public int getBitField2() {
            return bitField2;
        }

        public int getBitField3() {
            return bitField3;
        }
    }
    
    public static void main(String[] args) {
        BitFieldStruct b1 = new BitFieldStruct(1, 5, 10);
        BitFieldStruct b2 = new BitFieldStruct(0, 3, 7);
        BitFieldStruct b3 = new BitFieldStruct(1, 7, 15);
        BitFieldStruct b4 = new BitFieldStruct(0, 0, 0);
        BitFieldStruct b5 = new BitFieldStruct(1, 2, 4);

        System.out.println(b1.getBitField1() + ", " + b1.getBitField2() + ", " + b1.getBitField3());
        System.out.println(b2.getBitField1() + ", " + b2.getBitField2() + ", " + b2.getBitField3());
        System.out.println(b3.getBitField1() + ", " + b3.getBitField2() + ", " + b3.getBitField3());
        System.out.println(b4.getBitField1() + ", " + b4.getBitField2() + ", " + b4.getBitField3());
        System.out.println(b5.getBitField1() + ", " + b5.getBitField2() + ", " + b5.getBitField3());
    }
}