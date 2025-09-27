package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private final ExecutorService executor;
    private final ConcurrentHashMap<String, Lock> fileLocks;
    private final String directoryPath;
    
    public Task0(String directoryPath, int numThreads) {
        this.directoryPath = directoryPath;
        this.executor = Executors.newFixedThreadPool(numThreads);
        this.fileLocks = new ConcurrentHashMap<>();
    }
    
    public void processFiles() {
        try {
            Files.list(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    String fileName = file.getFileName().toString();
                    fileLocks.putIfAbsent(fileName, new ReentrantLock());
                    
                    executor.submit(() -> processFile(file.toFile()));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void processFile(File file) {
        Lock lock = fileLocks.get(file.getName());
        try {
            lock.lock();
            // Simulated file processing
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process each line
                    System.out.println("Thread " + Thread.currentThread().getName() + 
                                     " processing file: " + file.getName() + " - " + line);
                    Thread.sleep(100); // Simulate processing time
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String testDir = "test_files";
        new File(testDir).mkdirs();
        
        // Create test files
        for (int i = 1; i <= 5; i++) {
            try (PrintWriter writer = new PrintWriter(testDir + "/file" + i + ".txt")) {
                writer.println("Test content " + i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        Task0 processor = new Task0(testDir, 3);
        processor.processFiles();
        processor.shutdown();
    }
}
