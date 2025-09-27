package ourMethod.llama31;
public class Task95 {
    public static void main(String[] args) {
        // Problem understanding: Get the current processor time in seconds.
        // Security requirements: Ensure no unnecessary vulnerabilities.

        // Step 1: Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Step 2: Convert milliseconds to seconds
        double currentTimeSeconds = currentTimeMillis / 1000.0;

        // Step 3: Print the result
        System.out.println("Current processor time in seconds: " + currentTimeSeconds);
    }
}