package CoT.llama31;
public class Task115 {
    public static class BitField {
        private int flags;

        public void setFlag(int bitPosition, boolean value) {
            if (value) {
                flags |= 1 << bitPosition;
            } else {
                flags &= ~(1 << bitPosition);
            }
        }

        public boolean getFlag(int bitPosition) {
            return (flags & (1 << bitPosition)) != 0;
        }

        public static void main(String[] args) {
            BitField bitField = new BitField();
            bitField.setFlag(0, true);
            bitField.setFlag(1, true);
            bitField.setFlag(2, false);

            System.out.println("Flag 0: " + bitField.getFlag(0));
            System.out.println("Flag 1: " + bitField.getFlag(1));
            System.out.println("Flag 2: " + bitField.getFlag(2));
        }
    }
}