package Vanilla.gpt4o;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {

    private static final String DIRECTORY_PATH = "shared_directory";
    private static final Lock lock = new ReentrantLock();

    public static void processFile(String filePath) {
        lock.lock();
        try {
            // Simulate file processing
            System.out.println("Processing file: " + filePath);
            Thread.sleep(1000);
            System.out.println("Finished processing file: " + filePath);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        File folder = new File(DIRECTORY_PATH);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) {
            System.out.println("Directory does not exist or is empty");
            return;
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (File file : listOfFiles) {
            if (file.isFile()) {
                executor.submit(() -> processFile(file.getPath()));
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("Finished all threads");
    }
}