package ourMethod.codestral;
import java.util.concurrent.locks.ReentrantLock;

public class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(Task92::incrementCounter).start();
        }
    }

    private static void incrementCounter() {
        if (currentCounter <= maxCounter) {
            lock.lock();
            try {
                if (currentCounter <= maxCounter) {
                    currentCounter++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " is accessing the currentCounter at this moment. Current counter value: " + currentCounter);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}