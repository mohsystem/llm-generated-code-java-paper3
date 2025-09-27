package CoT.gpt4o;
public class Task115 {
    static class Data {
        private int bitField;

        public Data(int field) {
            this.bitField = field & 0xF; // Ensure only 4 bits are used
        }

        public int getBitField() {
            return bitField;
        }

        public void setBitField(int field) {
            this.bitField = field & 0xF; // Ensure only 4 bits are used
        }
    }

    public static void main(String[] args) {
        Data[] testCases = {
            new Data(0),
            new Data(1),
            new Data(15),
            new Data(16),
            new Data(255)
        };

        for (Data testCase : testCases) {
            System.out.println("Bit Field: " + testCase.getBitField());
        }
    }
}