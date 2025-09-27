package CoT.codestral;
import java.util.concurrent.locks.ReentrantLock;

public class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 5;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(Task92::updateCounter);
            threads[i].start();
        }
    }

    public static void updateCounter() {
        if (currentCounter <= maxCounter) {
            lock.lock();
            try {
                currentCounter++;
                System.out.println("Thread " + Thread.currentThread().getId() + " is accessing currentCounter: " + currentCounter);
            } finally {
                lock.unlock();
            }
        }
    }
}