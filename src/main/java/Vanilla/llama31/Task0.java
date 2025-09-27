package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

public class Task0 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for (File file : files) {
                if (file.isFile()) {
                    executor.submit(new FileProcessor(file));
                }
            }
            executor.shutdown();
        }
    }
}

class FileProcessor implements Runnable {
    private final File file;
    private final ReentrantLock lock = new ReentrantLock();

    public FileProcessor(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            processFile(file);
        } finally {
            lock.unlock();
        }
    }

    private void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Processing file: " + file.getName() + ", Line: " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}