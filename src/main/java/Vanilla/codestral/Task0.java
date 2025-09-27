package Vanilla.codestral;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private static final int NUM_THREADS = 4;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        File directory = new File("shared_directory");
        File[] files = directory.listFiles();

        for (File file : files) {
            executorService.submit(new FileProcessor(file));
        }

        executorService.shutdown();
    }

    private static class FileProcessor implements Runnable {
        private final File file;

        public FileProcessor(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                // Process the file
                System.out.println("Processing file: " + file.getName());
                // Add file processing logic here
            } finally {
                lock.unlock();
            }
        }
    }
}