package CoT.llama31;
public class Task95 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            printProcessorTime();
        }
    }

    public static void printProcessorTime() {
        long currentTime = System.nanoTime();
        double seconds = (double) currentTime / 1_000_000_000;
        System.out.println("Current processor time in seconds: " + seconds);
    }
}