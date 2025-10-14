package ourMethodv2.gpt4o;
import java.util.concurrent.locks.ReentrantLock;

class Task92 {
    private int currentCounter = 0;
    private final int maxCounter;
    private final ReentrantLock lock = new ReentrantLock();

    public Task92(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void accessCounter(String threadName) {
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
        Task92 task = new Task92(10);

        Runnable taskRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                task.accessCounter(Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(taskRunnable, "Thread 1");
        Thread t2 = new Thread(taskRunnable, "Thread 2");
        Thread t3 = new Thread(taskRunnable, "Thread 3");
        Thread t4 = new Thread(taskRunnable, "Thread 4");
        Thread t5 = new Thread(taskRunnable, "Thread 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}