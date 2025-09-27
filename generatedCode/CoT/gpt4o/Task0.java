package CoT.gpt4o;
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
    private static final Lock fileLock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                executorService.submit(() -> processFile(file));
            }
        }

        executorService.shutdown();
    }

    private static void processFile(File file) {
        fileLock.lock();
        try {
            if (file.isFile()) {
                System.out.println("Processing file: " + file.getName());
                // Simulate processing with sleep
                Thread.sleep(1000);
                // Example: Read the file content
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                System.out.println("Processed content of " + file.getName() + ": " + content.length() + " bytes");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }
}