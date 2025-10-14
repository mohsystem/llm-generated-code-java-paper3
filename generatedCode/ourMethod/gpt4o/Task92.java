package ourMethod.openai;
import java.util.concurrent.locks.ReentrantLock;

public class Task92 {
    private int currentCounter;
    private final int maxCounter;
    private final ReentrantLock lock;

    public Task92(int currentCounter, int maxCounter) {
        this.currentCounter = currentCounter;
        this.maxCounter = maxCounter;
        this.lock = new ReentrantLock();
    }

    public void incrementCounter(String threadName) {
        lock.lock();
        try {
            if (currentCounter <= maxCounter) {
                currentCounter++;
                System.out.println(threadName + " is accessing currentCounter: " + currentCounter);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Task92 task = new Task92(0, 10);

        for (int i = 0; i < 5; i++) {
            final String threadName = "Thread-" + i;
            new Thread(() -> {
                while (task.currentCounter <= task.maxCounter) {
                    task.incrementCounter(threadName);
                    try {
                        Thread.sleep(100); // simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}