package CoT.gemini;
public class Task115 {

    public static class BitFields {
        public int a = 2;
        public int b = 4;
        public int c = 2;
    }

    public static void main(String[] args) {
        BitFields bf1 = new BitFields();
        bf1.a = 3;
        bf1.b = 10;
        bf1.c = 1;
        System.out.println("Test case 1: a=" + bf1.a + ", b=" + bf1.b + ", c=" + bf1.c);

        BitFields bf2 = new BitFields();
        bf2.a = 0;
        bf2.b = 15;
        bf2.c = 3;
        System.out.println("Test case 2: a=" + bf2.a + ", b=" + bf2.b + ", c=" + bf2.c);


        BitFields bf3 = new BitFields();
        bf3.a = -1;
        bf3.b = -1;
        bf3.c = -1;
        System.out.println("Test case 3: a=" + bf3.a + ", b=" + bf3.b + ", c=" + bf3.c);

        BitFields bf4 = new BitFields();
        bf4.a = 1;
        bf4.b = 0;
        bf4.c = 2;
        System.out.println("Test case 4: a=" + bf4.a + ", b=" + bf4.b + ", c=" + bf4.c);

        BitFields bf5 = new BitFields();
        bf5.a = 2;
        bf5.b = 8;
        bf5.c = 0;
        System.out.println("Test case 5: a=" + bf5.a + ", b=" + bf5.b + ", c=" + bf5.c);
    }
}