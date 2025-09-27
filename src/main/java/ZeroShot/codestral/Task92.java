package ZeroShot.codestral;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task92 {
    private static int currentCounter = 0;
    private static int maxCounter = 5;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Worker(i)).start();
        }
    }

    private static class Worker implements Runnable {
        private int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (currentCounter < maxCounter) {
                        currentCounter++;
                        System.out.println("Thread " + id + " is accessing the currentCounter at this moment.");
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}