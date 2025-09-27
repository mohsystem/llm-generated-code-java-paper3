package ZeroShot.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/shared/directory";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        ReentrantLock lock = new ReentrantLock();

        for (File file : files) {
            if (file.isFile()) {
                executor.submit(() -> processFile(file, lock));
            }
        }

        executor.shutdown();
    }

    public static void processFile(File file, ReentrantLock lock) {
        lock.lock();
        try {
            // Simulate file processing
            System.out.println("Processing file: " + file.getName());
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("Processed by thread: " + Thread.currentThread().getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}