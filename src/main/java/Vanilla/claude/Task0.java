package Vanilla.claude;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class Task0 {
    private static final String DIRECTORY = "./files/";
    private static Set<String> inProcessFiles = Collections.synchronizedSet(new HashSet<>());
    private static ExecutorService executor;
    
    static class FileProcessor implements Runnable {
        private String filename;
        
        public FileProcessor(String filename) {
            this.filename = filename;
        }
        
        @Override
        public void run() {
            try {
                if (!inProcessFiles.add(filename)) {
                    return; // File is being processed by another thread
                }
                
                // Simulate file processing
                System.out.println("Thread " + Thread.currentThread().getName() + 
                                 " processing file: " + filename);
                Thread.sleep(1000);
                
                // Process file contents
                File file = new File(DIRECTORY + filename);
                if(file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Process each line
                        System.out.println(Thread.currentThread().getName() + 
                                         " reading: " + line);
                    }
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                inProcessFiles.remove(filename);
            }
        }
    }
    
    public static void processFiles(List<String> filenames) {
        executor = Executors.newFixedThreadPool(3);
        for(String filename : filenames) {
            executor.submit(new FileProcessor(filename));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        // Test cases
//        List<String> testCases = Arrays.asList(
//            Arrays.asList("file1.txt", "file2.txt", "file3.txt"),
//            Arrays.asList("file1.txt", "file1.txt"), // Same file twice
//            Arrays.asList("file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"),
//            Arrays.asList("nonexistent.txt"),
//            Arrays.asList("file1.txt", "file2.txt")
//        );
//
//        for(int i = 0; i < testCases.size(); i++) {
//            System.out.println("\\nTest case " + (i+1) + ":");
//            processFiles(testCases.get(i));
//        }
//    }
}
