package ZeroShot.gpt4o;
import java.util.concurrent.locks.ReentrantLock;

class Task92 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int currentCounter = 0;
    private static final int maxCounter = 5;

    static class CounterThread extends Thread {
        private final int threadId;

        CounterThread(int id) {
            this.threadId = id;
        }

        public void run() {
            lock.lock();
            try {
                if (currentCounter <= maxCounter) {
                    System.out.println("Thread " + threadId + " accessing counter: " + currentCounter);
                    currentCounter++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CounterThread(i);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}