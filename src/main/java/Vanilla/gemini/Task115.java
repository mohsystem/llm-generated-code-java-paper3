package Vanilla.gemini;
public class Task115 {
    static class BitField {
        int a = 2;
        int b = 4;
        int c = 2;

        public BitField(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b + ", c=" + c;
        }
    }


    public static void main(String[] args) {
        BitField bf1 = new BitField(1, 5, 3);
        BitField bf2 = new BitField(0, 15, 0);
        BitField bf3 = new BitField(3, 0, 1);
        BitField bf4 = new BitField(2, 10, 2);
        BitField bf5 = new BitField(1, 8, 3);

        System.out.println(bf1);
        System.out.println(bf2);
        System.out.println(bf3);
        System.out.println(bf4);
        System.out.println(bf5);

    }
}