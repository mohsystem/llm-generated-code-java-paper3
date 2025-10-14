package ZeroShot.openai;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Task187 {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private AtomicInteger hydrogenCount = new AtomicInteger(0);
    private AtomicInteger oxygenCount = new AtomicInteger(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        hydrogenCount.incrementAndGet();
        checkAndRelease();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        oxygenCount.incrementAndGet();
        checkAndRelease();
    }

    private void checkAndRelease() {
        if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
            hydrogenCount.set(0);
            oxygenCount.set(0);
            hydrogenSemaphore.release(2);
            oxygenSemaphore.release();
        }
    }

    public static void main(String[] args) {
        Task187 task = new Task187();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        String water = "HOHHOHHOHHOH";
        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        task.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        task.oxygen(releaseOxygen);
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