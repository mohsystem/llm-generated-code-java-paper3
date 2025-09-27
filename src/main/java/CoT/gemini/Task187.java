package CoT.gemini;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task187 {

    private int hydrogenCount = 0;
    private int oxygenCount = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void releaseHydrogen() throws InterruptedException {
        lock.lock();
        try {
            hydrogenCount++;
            while (hydrogenCount < 2 || oxygenCount == 0) {
                condition.await();
            }
            hydrogenCount -= 2;
            oxygenCount--;
            condition.signalAll(); // Signal oxygen and other hydrogen
        } finally {
            lock.unlock();
        }
        // System.out.print("H"); // Indicate bond formation
    }

    public void releaseOxygen() throws InterruptedException {
        lock.lock();
        try {
            oxygenCount++;
            while (hydrogenCount < 2) {
                condition.await();
            }
            oxygenCount--;
            hydrogenCount -= 2;
            condition.signalAll(); // Signal hydrogen
        } finally {
            lock.unlock();
        }
        // System.out.print("O"); // Indicate bond formation
    }


    public static void main(String[] args) {
        Task187 h2o = new Task187();
        String[] inputs = {"HOH", "OOHHHH", "HOHOHO", "HHHOOO", "OHHHOO"};
        for (String input : inputs) {
            final String water = input;
            Thread[] threads = new Thread[water.length()];
            for (int i = 0; i < water.length(); i++) {
                char c = water.charAt(i);
                final int index = i;
                if (c == 'H') {
                    threads[i] = new Thread(() -> {
                        try {
                            h2o.releaseHydrogen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    threads[i] = new Thread(() -> {
                        try {
                            h2o.releaseOxygen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(); // Separate output for each test case

        }
    }
}