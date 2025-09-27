package ourMethod.gemini;
import java.util.concurrent.locks.ReentrantLock;

class Task92 {

    private int currentCounter = 0;
    private int maxCounter;
    private ReentrantLock lock = new ReentrantLock();

    public Task92(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void incrementAndPrint(String threadName) {
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
        Task92 task = new Task92(5);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task.incrementAndPrint("Thread 1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task.incrementAndPrint("Thread 2");

            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task.incrementAndPrint("Thread 3");
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task.incrementAndPrint("Thread 4");
            }
        });
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                task.incrementAndPrint("Thread 5");
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}