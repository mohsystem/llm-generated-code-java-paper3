package ZeroShot.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Task0 {

    private static final ReentrantLock fileLock = new ReentrantLock();
    private static final String SHARED_DIRECTORY = "shared_directory"; // Replace with your directory

    public static void processFile(Path filePath) {
        try {
            fileLock.lock();
            // Process the file
            System.out.println(Thread.currentThread().getName() + " processing " + filePath);
            Thread.sleep(1000); // Simulate processing time
            String content = Files.readString(filePath);
            // Example: convert content to uppercase
            String processedContent = content.toUpperCase();
            Files.writeString(filePath, processedContent);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        File directory = new File(SHARED_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Create some dummy files for testing
        try {
            Files.writeString(Path.of(SHARED_DIRECTORY, "file1.txt"), "content1");
            Files.writeString(Path.of(SHARED_DIRECTORY, "file2.txt"), "content2");
            Files.writeString(Path.of(SHARED_DIRECTORY, "file3.txt"), "content3");
            Files.writeString(Path.of(SHARED_DIRECTORY, "file4.txt"), "content4");
            Files.writeString(Path.of(SHARED_DIRECTORY, "file5.txt"), "content5");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ExecutorService executor = Executors.newFixedThreadPool(3); // Adjust thread pool size as needed


        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                executor.submit(() -> processFile(file.toPath()));
            }
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS); // Wait for tasks to complete

    }
}