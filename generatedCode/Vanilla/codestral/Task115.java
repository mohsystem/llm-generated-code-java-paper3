package Vanilla.codestral;
public class Task115 {
    private boolean bit1;
    private boolean bit2;
    private boolean bit3;

    public Task115(boolean bit1, boolean bit2, boolean bit3) {
        this.bit1 = bit1;
        this.bit2 = bit2;
        this.bit3 = bit3;
    }

    public static void main(String[] args) {
        Task115 test1 = new Task115(true, false, true);
        Task115 test2 = new Task115(false, true, false);
        // Add more test cases as needed
    }
}