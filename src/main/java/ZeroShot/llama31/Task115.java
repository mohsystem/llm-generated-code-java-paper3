package ZeroShot.llama31;
public class Task115 {
    public static class BitFields {
        public int bit0;
        public int bit1to3;
        public int bit4;
        public int bit5;
        public int bit6to7;

        public BitFields(int bit0, int bit1to3, int bit4, int bit5, int bit6to7) {
            this.bit0 = bit0;
            this.bit1to3 = bit1to3;
            this.bit4 = bit4;
            this.bit5 = bit5;
            this.bit6to7 = bit6to7;
        }

        public void printValues() {
            System.out.println("bit0: " + bit0);
            System.out.println("bit1to3: " + bit1to3);
            System.out.println("bit4: " + bit4);
            System.out.println("bit5: " + bit5);
            System.out.println("bit6to7: " + bit6to7);
        }
    }

    public static void main(String[] args) {
        BitFields task = new BitFields(1, 5, 1, 0, 3);
        task.printValues();
    }
}