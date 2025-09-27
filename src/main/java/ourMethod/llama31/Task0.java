package ourMethod.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        String directoryPath = "/path/to/shared/directory";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for (File file : files) {
                executor.submit(() -> processFile(file));
            }
            executor.shutdown();
        }
    }

    private static void processFile(File file) {
        lock.lock();
        try {
            // Process the file here
            System.out.println("Processing file: " + file.getName());
            // Example: Writing to a new file
            try (FileWriter writer = new FileWriter("processed_" + file.getName())) {
                writer.write("File processed successfully");
            } catch (IOException e) {
                System.err.println("Error processing file: " + e.getMessage());
            }
        } finally {
            lock.unlock();
        }
    }
}