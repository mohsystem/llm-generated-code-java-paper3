package Vanilla.gpt4o;
public class Task115 {
    static class BitFieldStruct {
        int a : 1;
        int b : 1;
        int c : 2;
    }

    public static void main(String[] args) {
        BitFieldStruct bf = new BitFieldStruct();
        bf.a = 1;
        bf.b = 0;
        bf.c = 2;

        System.out.println("Test Case 1: a = " + bf.a + ", b = " + bf.b + ", c = " + bf.c);
        
        bf.a = 0;
        bf.b = 1;
        bf.c = 1;
        System.out.println("Test Case 2: a = " + bf.a + ", b = " + bf.b + ", c = " + bf.c);

        bf.a = 1;
        bf.b = 1;
        bf.c = 0;
        System.out.println("Test Case 3: a = " + bf.a + ", b = " + bf.b + ", c = " + bf.c);

        bf.a = 0;
        bf.b = 0;
        bf.c = 3;
        System.out.println("Test Case 4: a = " + bf.a + ", b = " + bf.b + ", c = " + bf.c);

        bf.a = 1;
        bf.b = 1;
        bf.c = 3;
        System.out.println("Test Case 5: a = " + bf.a + ", b = " + bf.b + ", c = " + bf.c);
    }
}