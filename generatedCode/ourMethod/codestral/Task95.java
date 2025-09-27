package ourMethod.codestral;
public class Task95 {
    public static void main(String[] args) {
        try {
            long startTime = System.nanoTime();
            double seconds = (double) startTime / 1000000000.0;
            System.out.println("Current processor time in seconds: " + seconds);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}