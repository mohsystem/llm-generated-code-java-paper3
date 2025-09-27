package ourMethod.claude;

public class Task115 {
    private static class BitFields {
        private int data;
        
        public BitFields() {
            this.data = 0; // Proper initialization
        }
        
        public void setField1(int value) {
            if (value < 0 || value > 7) { // Validate input range
                throw new IllegalArgumentException("Field1 must be between 0 and 7");
            }
            // Clear bits and set new value (3 bits)
            data = (data & ~0x7) | (value & 0x7);
        }
        
        public void setField2(int value) {
            if (value < 0 || value > 15) { // Validate input range
                throw new IllegalArgumentException("Field2 must be between 0 and 15");
            }
            // Clear bits and set new value (4 bits)
            data = (data & ~(0xF << 3)) | ((value & 0xF) << 3);
        }
        
        public int getField1() {
            return data & 0x7;
        }
        
        public int getField2() {
            return (data >> 3) & 0xF;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        BitFields bf = new BitFields();
        
        // Test case 1: Set and get field1
        bf.setField1(5);
        System.out.println("Field1: " + bf.getField1()); // Should print 5
        
        // Test case 2: Set and get field2
        bf.setField2(10);
        System.out.println("Field2: " + bf.getField2()); // Should print 10
        
        // Test case 3: Set both fields
        bf.setField1(3);
        bf.setField2(12);
        System.out.println("Field1: " + bf.getField1() + ", Field2: " + bf.getField2());
        
        // Test case 4: Set field1 to max value
        bf.setField1(7);
        System.out.println("Field1 max: " + bf.getField1());
        
        // Test case 5: Set field2 to max value
        bf.setField2(15);
        System.out.println("Field2 max: " + bf.getField2());
    }
}
