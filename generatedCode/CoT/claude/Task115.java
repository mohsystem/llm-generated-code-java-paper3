package CoT.claude;

public class Task115 {
    public static class BitFields {
        private int data;
        
        // Constructor with validation
        public BitFields(int field1, int field2, int field3) {
            if (field1 < 0 || field1 > 7) throw new IllegalArgumentException("field1 must be 0-7");
            if (field2 < 0 || field2 > 15) throw new IllegalArgumentException("field2 must be 0-15");
            if (field3 < 0 || field3 > 31) throw new IllegalArgumentException("field3 must be 0-31");
            
            data = (field1 & 0x7) | ((field2 & 0xF) << 3) | ((field3 & 0x1F) << 7);
        }
        
        public int getField1() { return data & 0x7; }
        public int getField2() { return (data >> 3) & 0xF; }
        public int getField3() { return (data >> 7) & 0x1F; }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            BitFields test1 = new BitFields(3, 7, 15);
            System.out.println("Test1: " + test1.getField1() + " " + test1.getField2() + " " + test1.getField3());
            
            BitFields test2 = new BitFields(5, 10, 20);
            System.out.println("Test2: " + test2.getField1() + " " + test2.getField2() + " " + test2.getField3());
            
            BitFields test3 = new BitFields(0, 0, 0);
            System.out.println("Test3: " + test3.getField1() + " " + test3.getField2() + " " + test3.getField3());
            
            BitFields test4 = new BitFields(7, 15, 31);
            System.out.println("Test4: " + test4.getField1() + " " + test4.getField2() + " " + test4.getField3());
            
            BitFields test5 = new BitFields(1, 8, 16);
            System.out.println("Test5: " + test5.getField1() + " " + test5.getField2() + " " + test5.getField3());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
