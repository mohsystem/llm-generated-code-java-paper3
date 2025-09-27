package Vanilla.gemini;
import java.util.concurrent.locks.ReentrantLock;

class Task92 {
    private int currentCounter = 0;
    private int maxCounter;
    private ReentrantLock lock = new ReentrantLock();

    public Task92(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void incrementCounter(int threadId) {
        if (currentCounter <= maxCounter) {
            lock.lock();
            try {
                if (currentCounter <= maxCounter) {
                    currentCounter++;
                    System.out.println("Thread " + threadId + " accessing counter: " + currentCounter);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Task92 counter = new Task92(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementCounter(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementCounter(2);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementCounter(3);
            }
        });
        
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementCounter(4);
            }
        });
        
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementCounter(5);
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}