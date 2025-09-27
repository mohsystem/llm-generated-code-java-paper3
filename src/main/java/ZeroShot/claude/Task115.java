package ZeroShot.claude;

public class Task115 {
    private int data;
    
    public void setFlag1(boolean value) {
        if(value)
            data |= 1;
        else 
            data &= ~1;
    }
    
    public void setFlag2(boolean value) {
        if(value)
            data |= 2;
        else
            data &= ~2;
    }
    
    public void setValue(int val) {
        // Use only bits 2-7 (6 bits)
        val = val & 0x3F; // Mask to keep only 6 bits
        data = (data & 0x3) | (val << 2);
    }
    
    public boolean getFlag1() {
        return (data & 1) == 1;
    }
    
    public boolean getFlag2() {
        return (data & 2) == 2;
    }
    
    public int getValue() {
        return (data >> 2) & 0x3F;
    }
    
    public static void main(String[] args) {
        Task115 bf = new Task115();
        
        // Test case 1
        bf.setFlag1(true);
        bf.setFlag2(false);
        bf.setValue(15);
        System.out.println("Test 1: " + bf.getFlag1() + " " + bf.getFlag2() + " " + bf.getValue());
        
        // Test case 2
        bf.setFlag1(false);
        bf.setFlag2(true);
        bf.setValue(30);
        System.out.println("Test 2: " + bf.getFlag1() + " " + bf.getFlag2() + " " + bf.getValue());
        
        // Test case 3
        bf.setFlag1(true);
        bf.setFlag2(true);
        bf.setValue(63);
        System.out.println("Test 3: " + bf.getFlag1() + " " + bf.getFlag2() + " " + bf.getValue());
        
        // Test case 4
        bf.setFlag1(false);
        bf.setFlag2(false);
        bf.setValue(0);
        System.out.println("Test 4: " + bf.getFlag1() + " " + bf.getFlag2() + " " + bf.getValue());
        
        // Test case 5
        bf.setFlag1(true);
        bf.setFlag2(false);
        bf.setValue(45);
        System.out.println("Test 5: " + bf.getFlag1() + " " + bf.getFlag2() + " " + bf.getValue());
    }
}
