package CoT.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Task0 {

    private static final int NUM_THREADS = 5; // Adjust as needed
    private static final String SHARED_DIRECTORY = "path/to/shared/directory"; // Replace with actual path

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Path directoryPath = Paths.get(SHARED_DIRECTORY);

        try (Stream<Path> files = Files.list(directoryPath)) {
            files.filter(Files::isRegularFile).forEach(filePath -> {
                executor.submit(() -> {
                    try {
                        processFile(filePath);
                    } catch (IOException e) {
                        System.err.println("Error processing file " + filePath + ": " + e.getMessage());
                    }
                });
            });
        } catch (IOException e) {
            System.err.println("Error listing files in directory " + SHARED_DIRECTORY + ": " + e.getMessage());
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Executor termination interrupted: " + e.getMessage());
        }
    }

    private synchronized static void processFile(Path filePath) throws IOException {
        // Simulate file processing
        System.out.println("Processing file: " + filePath + " by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished processing file: " + filePath + " by thread " + Thread.currentThread().getName());


    }
}