package CoT.codestral;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Task0 {
    private Queue<File> files = new ConcurrentLinkedQueue<>();
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private ReentrantLock lock = new ReentrantLock();

    public void processFiles(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        while (!files.isEmpty()) {
            executor.submit(() -> {
                File file = files.poll();
                if (file != null) {
                    lock.lock();
                    try {
                        // process file
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        Task0 task = new Task0();
        task.processFiles(new File("shared_directory"));
    }
}