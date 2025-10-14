package ourMethodv2.gpt4o;
public class Task115 {
    static class BitFieldClass {
        private int bit1;
        private int bit2;
        private int bit3;

        public BitFieldClass(int bit1, int bit2, int bit3) {
            this.bit1 = bit1 & 0x1; // mask to ensure bit field
            this.bit2 = bit2 & 0x1;
            this.bit3 = bit3 & 0x1;
        }

        public int getBit1() {
            return bit1;
        }

        public int getBit2() {
            return bit2;
        }

        public int getBit3() {
            return bit3;
        }
    }

    public static void main(String[] args) {
        BitFieldClass obj1 = new BitFieldClass(1, 0, 1);
        BitFieldClass obj2 = new BitFieldClass(0, 1, 0);
        BitFieldClass obj3 = new BitFieldClass(1, 1, 1);
        BitFieldClass obj4 = new BitFieldClass(0, 0, 0);
        BitFieldClass obj5 = new BitFieldClass(1, 0, 0);

        System.out.println("Object 1: " + obj1.getBit1() + " " + obj1.getBit2() + " " + obj1.getBit3());
        System.out.println("Object 2: " + obj2.getBit1() + " " + obj2.getBit2() + " " + obj2.getBit3());
        System.out.println("Object 3: " + obj3.getBit1() + " " + obj3.getBit2() + " " + obj3.getBit3());
        System.out.println("Object 4: " + obj4.getBit1() + " " + obj4.getBit2() + " " + obj4.getBit3());
        System.out.println("Object 5: " + obj5.getBit1() + " " + obj5.getBit2() + " " + obj5.getBit3());
    }
}