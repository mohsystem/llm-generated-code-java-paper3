package ourMethod.gemini;
public class Task115 {

    public static class BitFields {
        public int flag1 : 1;
        public int flag2 : 1;
        public int value : 6;
    }

    public static void main(String[] args) {
        BitFields bf1 = new BitFields();
        bf1.flag1 = 1;
        bf1.flag2 = 0;
        bf1.value = 32;

        System.out.println("bf1: flag1=" + bf1.flag1 + ", flag2=" + bf1.flag2 + ", value=" + bf1.value);


        BitFields bf2 = new BitFields();
        bf2.flag1 = 0;
        bf2.flag2 = 1;
        bf2.value = 15;
        System.out.println("bf2: flag1=" + bf2.flag1 + ", flag2=" + bf2.flag2 + ", value=" + bf2.value);

        BitFields bf3 = new BitFields();
        bf3.flag1 = 1;
        bf3.flag2 = 1;
        bf3.value = 63;
        System.out.println("bf3: flag1=" + bf3.flag1 + ", flag2=" + bf3.flag2 + ", value=" + bf3.value);

        BitFields bf4 = new BitFields();
        bf4.flag1 = 0;
        bf4.flag2 = 0;
        bf4.value = 0;

        System.out.println("bf4: flag1=" + bf4.flag1 + ", flag2=" + bf4.flag2 + ", value=" + bf4.value);

        BitFields bf5 = new BitFields();
        bf5.flag1 = 1;
        bf5.flag2 = 0;
        bf5.value = 55;
        System.out.println("bf5: flag1=" + bf5.flag1 + ", flag2=" + bf5.flag2 + ", value=" + bf5.value);



    }
}