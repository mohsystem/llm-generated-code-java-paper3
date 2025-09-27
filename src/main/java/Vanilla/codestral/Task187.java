package Vanilla.codestral;
import java.util.concurrent.Semaphore;

public class Task187 {
    private Semaphore hydrogen;
    private Semaphore oxygen;
    private Semaphore barrier;

    public Task187() {
        this.hydrogen = new Semaphore(0);
        this.oxygen = new Semaphore(0);
        this.barrier = new Semaphore(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        barrier.acquire();
        releaseHydrogen.run();
        hydrogen.release();
        tryToFormWater();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        barrier.acquire();
        releaseOxygen.run();
        oxygen.release();
        tryToFormWater();
    }

    private void tryToFormWater() throws InterruptedException {
        if (hydrogen.availablePermits() >= 2 && oxygen.availablePermits() >= 1) {
            hydrogen.acquire(2);
            oxygen.acquire();
            System.out.print("HHO");
            barrier.release(3);
        }
    }

    public static void main(String[] args) {
        Task187 task = new Task187();
        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");
        Thread[] threads = new Thread[6];
        for (int i = 0; i < 6; i++) {
            if (i % 3 == 0) {
                threads[i] = new Thread(() -> {
                    try {
                        task.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        task.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}