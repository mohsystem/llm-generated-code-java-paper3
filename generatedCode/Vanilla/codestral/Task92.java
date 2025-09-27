package Vanilla.codestral;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task92 {
    private int currentCounter = 0;
    private int maxCounter = 5;
    private Lock lock = new ReentrantLock();

    public void accessResource(int threadNumber) {
        lock.lock();
        try {
            if (currentCounter <= maxCounter) {
                currentCounter++;
                System.out.println("Thread " + threadNumber + " is accessing the currentCounter: " + currentCounter);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Task92 task = new Task92();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> task.accessResource(i)).start();
        }
    }
}