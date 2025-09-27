package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private static final String SHARED_DIR = "shared_directory";
    private static final Map<String, ReentrantLock> fileLocks = new ConcurrentHashMap<>();
    
    static class FileProcessor implements Runnable {
        private final String fileName;
        
        public FileProcessor(String fileName) {
            this.fileName = fileName;
        }
        
        @Override
        public void run() {
            ReentrantLock lock = fileLocks.computeIfAbsent(fileName, k -> new ReentrantLock());
            
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        processFile(fileName);
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        private void processFile(String fileName) {
            try {
                Path filePath = Paths.get(SHARED_DIR, fileName);
                String content = new String(Files.readAllBytes(filePath));
                // Simulate processing
                Thread.sleep(100);
                // Write processed content
                Files.write(filePath, (content + " processed").getBytes());
                System.out.println("Thread " + Thread.currentThread().getName() + 
                                 " processed file: " + fileName);
            } catch (IOException | InterruptedException e) {
                System.err.println("Error processing file: " + fileName);
            }
        }
    }
    
    public static void main(String[] args) {
        // Create shared directory if it doesn't exist
        new File(SHARED_DIR).mkdirs();
        
        // Create test files
        createTestFiles();
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Test cases
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : testFiles) {
            executor.submit(new FileProcessor(file));
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private static void createTestFiles() {
        try {
            for (int i = 1; i <= 5; i++) {
                Path filePath = Paths.get(SHARED_DIR, "file" + i + ".txt");
                Files.write(filePath, ("Initial content " + i).getBytes());
            }
        } catch (IOException e) {
            System.err.println("Error creating test files");
        }
    }
}
