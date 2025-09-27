package ZeroShot.gpt4o;
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Task0 {
    private final ConcurrentHashMap<Path, Lock> fileLocks = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void processDirectory(String directoryPath) {
        try {
            Files.list(Paths.get(directoryPath)).forEach(this::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFile(Path filePath) {
        executor.submit(() -> {
            Lock lock = fileLocks.computeIfAbsent(filePath, path -> new ReentrantLock());
            lock.lock();
            try {
                // Simulate file processing
                System.out.println("Processing file: " + filePath);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Task0 task = new Task0();
        task.processDirectory("test_directory");
        task.shutdown();
    }
}