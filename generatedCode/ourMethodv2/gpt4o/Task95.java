package ourMethodv2.gpt4o;
public class Task95 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Current processor time: " + getProcessorTimeInSeconds() + " seconds");
        }
    }

    public static double getProcessorTimeInSeconds() {
        return (double) System.nanoTime() / 1_000_000_000.0;
    }
}