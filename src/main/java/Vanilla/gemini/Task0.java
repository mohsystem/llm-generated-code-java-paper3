package Vanilla.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {

    private static final ReentrantLock fileLock = new ReentrantLock();
    private static final String SHARED_DIRECTORY = "shared_directory"; // Replace with your shared directory path

    public static void processFile(Path filePath) {
        try {
            fileLock.lock();
            // Process the file
            byte[] fileContent = Files.readAllBytes(filePath);
            // Simulate processing
            Thread.sleep(1000); // Replace with your actual processing logic
            System.out.println(Thread.currentThread().getName() + " processed: " + filePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        File directory = new File(SHARED_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create some dummy files
        try {
            for (int i = 1; i <= 5; i++) {
                Files.createFile(Path.of(SHARED_DIRECTORY + "/file" + i + ".txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        ExecutorService executor = Executors.newFixedThreadPool(3); // Adjust thread pool size as needed

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    executor.submit(() -> processFile(file.toPath()));
                }
            }
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("File processing completed.");
    }
}