package CoT.gemini;
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
                if (currentCounter <= maxCounter) { // Double-checked locking
                    currentCounter++;
                    System.out.println("Thread " + threadId + " accessed counter: " + currentCounter);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Task92 counter = new Task92(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter(2);

            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter(3);

            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter(4);

            }
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter(5);

            }
        });



        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
}