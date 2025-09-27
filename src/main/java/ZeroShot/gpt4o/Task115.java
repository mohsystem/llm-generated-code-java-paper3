package ZeroShot.gpt4o;
public class Task115 {
    static class BitFieldClass {
        private int field1;
        private int field2;

        public BitFieldClass(int field1, int field2) {
            this.field1 = field1 & 0x3; // 2 bits
            this.field2 = field2 & 0xF; // 4 bits
        }

        public int getField1() {
            return field1;
        }

        public int getField2() {
            return field2;
        }
    }

    public static void main(String[] args) {
        BitFieldClass example1 = new BitFieldClass(2, 5);
        BitFieldClass example2 = new BitFieldClass(3, 15);
        BitFieldClass example3 = new BitFieldClass(0, 0);
        BitFieldClass example4 = new BitFieldClass(1, 8);
        BitFieldClass example5 = new BitFieldClass(3, 7);

        System.out.println("Example1: " + example1.getField1() + ", " + example1.getField2());
        System.out.println("Example2: " + example2.getField1() + ", " + example2.getField2());
        System.out.println("Example3: " + example3.getField1() + ", " + example3.getField2());
        System.out.println("Example4: " + example4.getField1() + ", " + example4.getField2());
        System.out.println("Example5: " + example5.getField1() + ", " + example5.getField2());
    }
}