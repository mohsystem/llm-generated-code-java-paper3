package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class Task0 {
    private final ConcurrentHashMap<String, Lock> fileLocks = new ConcurrentHashMap<>();
    private final ExecutorService executor;
    private final Path directory;
    
    public Task0(String dirPath, int numThreads) {
        directory = Paths.get(dirPath);
        executor = Executors.newFixedThreadPool(numThreads);
        if (!Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                throw new RuntimeException("Could not create directory: " + e.getMessage());
            }
        }
    }
    
    public void processFiles() {
        try {
            List<Path> files = Files.list(directory).collect(Collectors.toList());
            List<Future<?>> futures = new ArrayList<>();
            
            for (Path file : files) {
                Future<?> future = executor.submit(() -> processFile(file));
                futures.add(future);
            }
            
            for (Future<?> future : futures) {
                try {
                    future.get(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error listing files: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
    
    private void processFile(Path file) {
        String fileName = file.toString();
        Lock lock = fileLocks.computeIfAbsent(fileName, k -> new ReentrantLock());
        
        if (lock.tryLock()) {
            try {
                System.out.println("Processing file: " + fileName + " by thread: " + Thread.currentThread().getName());
                // Simulate file processing
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                fileLocks.remove(fileName);
            }
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String testDir = "test_files";
        try {
            // Create test directory and files
            Path dir = Paths.get(testDir);
            Files.createDirectories(dir);
            
            for (int i = 1; i <= 5; i++) {
                Path file = dir.resolve("file" + i + ".txt");
                Files.writeString(file, "Test content " + i);
            }
            
            // Test with different numbers of threads
            Task0 processor1 = new Task0(testDir, 2);
            processor1.processFiles();
            
            Task0 processor2 = new Task0(testDir, 3);
            processor2.processFiles();
            
            Task0 processor3 = new Task0(testDir, 4);
            processor3.processFiles();
            
            Task0 processor4 = new Task0(testDir, 5);
            processor4.processFiles();
            
            Task0 processor5 = new Task0(testDir, 1);
            processor5.processFiles();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
