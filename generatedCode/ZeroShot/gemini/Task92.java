package ZeroShot.gemini;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

class Task92 {
    private AtomicInteger currentCounter = new AtomicInteger(0);
    private int maxCounter;
    private ReentrantLock lock = new ReentrantLock();

    public Task92(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void incrementAndPrint(int threadId) {
        while (currentCounter.get() <= maxCounter) {
            if (currentCounter.get() <= maxCounter) {
                lock.lock();
                try {
                    if (currentCounter.get() <= maxCounter) {
                        currentCounter.incrementAndGet();
                        System.out.println("Thread " + threadId + " accessing currentCounter: " + currentCounter.get());
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        Task92 counter = new Task92(5);
        Thread t1 = new Thread(() -> counter.incrementAndPrint(1));
        Thread t2 = new Thread(() -> counter.incrementAndPrint(2));
        Thread t3 = new Thread(() -> counter.incrementAndPrint(3));
        Thread t4 = new Thread(() -> counter.incrementAndPrint(4));
        Thread t5 = new Thread(() -> counter.incrementAndPrint(5));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

           try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
    }
}