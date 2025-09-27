package ourMethod.llama31;
public class Task115 {
    private boolean flag1;
    private boolean flag2;
    private boolean flag3;
    private byte flags;

    public Task115() {
        flags = 0;
    }

    public void setFlag1(boolean value) {
        if (value) {
            flags |= 0x01;
        } else {
            flags &= ~0x01;
        }
    }

    public void setFlag2(boolean value) {
        if (value) {
            flags |= 0x02;
        } else {
            flags &= ~0x02;
        }
    }

    public void setFlag3(boolean value) {
        if (value) {
            flags |= 0x04;
        } else {
            flags &= ~0x04;
        }
    }

    public boolean getFlag1() {
        return (flags & 0x01) != 0;
    }

    public boolean getFlag2() {
        return (flags & 0x02) != 0;
    }

    public boolean getFlag3() {
        return (flags & 0x04) != 0;
    }

    public static void main(String[] args) {
        Task115 task = new Task115();
        task.setFlag1(true);
        task.setFlag2(false);
        task.setFlag3(true);

        System.out.println("Flag1: " + task.getFlag1());
        System.out.println("Flag2: " + task.getFlag2());
        System.out.println("Flag3: " + task.getFlag3());
    }
}