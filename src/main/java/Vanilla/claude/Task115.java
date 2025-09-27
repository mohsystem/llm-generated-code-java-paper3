package Vanilla.claude;

public class Task115 {
    private int value;
    private static final int FIELD1_MASK = 0b11111;         // 5 bits
    private static final int FIELD2_MASK = 0b111111 << 5;   // 6 bits 
    private static final int FIELD3_MASK = 0b11111 << 11;   // 5 bits

    public Task115() {
        value = 0;
    }

    public void setField1(int field1) {
        value = (value & ~FIELD1_MASK) | (field1 & FIELD1_MASK);
    }

    public void setField2(int field2) {
        value = (value & ~FIELD2_MASK) | ((field2 << 5) & FIELD2_MASK);
    }

    public void setField3(int field3) {
        value = (value & ~FIELD3_MASK) | ((field3 << 11) & FIELD3_MASK);
    }

    public int getField1() {
        return value & FIELD1_MASK;
    }

    public int getField2() {
        return (value & FIELD2_MASK) >> 5;
    }

    public int getField3() {
        return (value & FIELD3_MASK) >> 11;
    }

    public static void main(String[] args) {
        Task115 bf = new Task115();
        
        // Test case 1
        bf.setField1(15);
        bf.setField2(35);
        bf.setField3(20);
        System.out.println("Test 1: " + bf.getField1() + " " + bf.getField2() + " " + bf.getField3());

        // Test case 2
        bf.setField1(31);
        bf.setField2(63);
        bf.setField3(31);
        System.out.println("Test 2: " + bf.getField1() + " " + bf.getField2() + " " + bf.getField3());

        // Test case 3
        bf.setField1(0);
        bf.setField2(0);
        bf.setField3(0);
        System.out.println("Test 3: " + bf.getField1() + " " + bf.getField2() + " " + bf.getField3());

        // Test case 4
        bf.setField1(7);
        bf.setField2(42);
        bf.setField3(12);
        System.out.println("Test 4: " + bf.getField1() + " " + bf.getField2() + " " + bf.getField3());

        // Test case 5
        bf.setField1(25);
        bf.setField2(55);
        bf.setField3(28);
        System.out.println("Test 5: " + bf.getField1() + " " + bf.getField2() + " " + bf.getField3());
    }
}
