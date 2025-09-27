package ZeroShot.codestral;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Task0 {
    private static final int NUM_THREADS = 5;
    private static final String SHARED_DIR = "/path/to/shared/directory";
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        File dir = new File(SHARED_DIR);
        File[] files = dir.listFiles();
        for (File file : files) {
            executor.submit(new FileProcessor(file));
        }
        executor.shutdown();
    }

    private static class FileProcessor implements Runnable {
        private final File file;
        private final ReentrantLock lock = new ReentrantLock();

        FileProcessor(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            if (lock.tryLock()) {
                try {
                    // process the file
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}