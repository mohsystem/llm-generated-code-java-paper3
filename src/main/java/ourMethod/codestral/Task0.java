package ourMethod.codestral;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Task0 {
    private static final int THREAD_POOL_SIZE = 5;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        File directory = new File("/path/to/directory");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    executorService.submit(new FileProcessor(file));
                }
            }
        }

        executorService.shutdown();
    }

    private static class FileProcessor implements Runnable {
        private File file;

        public FileProcessor(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                // Process the file
                System.out.println("Processing file: " + file.getName());
                // Releasing the semaphore after processing the file
                semaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}