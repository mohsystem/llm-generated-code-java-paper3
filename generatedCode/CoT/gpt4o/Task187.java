package CoT.gpt4o;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Task187 {
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private AtomicInteger hydrogenCount = new AtomicInteger(0);
    private AtomicInteger oxygenCount = new AtomicInteger(0);

    public void releaseHydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        if (hydrogenCount.incrementAndGet() == 2) {
            hydrogenCount.set(0);
            oxygenSemaphore.release();
        }
    }

    public void releaseOxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        if (oxygenCount.incrementAndGet() == 1) {
            oxygenCount.set(0);
            hydrogenSemaphore.release(2);
        }
    }

    public static void main(String[] args) {
        Task187 task = new Task187();
        String water = "OOHHHH";
        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        task.releaseHydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        task.releaseOxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
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
                Thread.currentThread().interrupt();
            }
        }
    }
}