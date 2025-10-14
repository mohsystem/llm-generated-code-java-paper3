package ourMethodv2.gpt4o;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private static final Lock lock = new ReentrantLock();

    public static void processFile(File file) {
        lock.lock();
        try {
            // Simulate file processing
            System.out.println("Processing file: " + file.getName());
            Thread.sleep(1000);
            System.out.println("Completed file: " + file.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        File directory = new File("shared_directory");
        File[] files = directory.listFiles();

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (File file : files) {
                executor.submit(() -> processFile(file));
            }
            executor.shutdown();
        }
    }
}