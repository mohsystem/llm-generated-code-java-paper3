package ourMethod.gpt4o;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task0 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        String directoryPath = "shared_directory_path"; // Define your shared directory path
        processFilesConcurrently(directoryPath);
    }

    public static void processFilesConcurrently(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles();
        if (files == null) return;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (File file : files) {
            executor.execute(() -> processFile(file));
        }
        executor.shutdown();
    }

    private static void processFile(File file) {
        lock.lock();
        try {
            // Simulate file processing
            System.out.println("Processing file: " + file.getName());
            Thread.sleep(100); // Simulate processing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}