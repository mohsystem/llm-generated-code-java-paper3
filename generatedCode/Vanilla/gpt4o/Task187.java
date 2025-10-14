package Vanilla.openai;
import java.util.concurrent.Semaphore;

public class Task187 {

    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;

    public Task187() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(0);
    }

    public void releaseHydrogen() throws InterruptedException {
        hydrogenSemaphore.acquire();
        System.out.print("H");
        if (hydrogenSemaphore.availablePermits() == 0) {
            oxygenSemaphore.release();
        }
    }

    public void releaseOxygen() throws InterruptedException {
        oxygenSemaphore.acquire(1);
        System.out.print("O");
        hydrogenSemaphore.release(2);
    }

    public static void main(String[] args) {
        Task187 task = new Task187();

        String water = "HOHOOHHHHHH";
        
        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            final char molecule = water.charAt(i);
            threads[i] = new Thread(() -> {
                try {
                    if (molecule == 'H') {
                        task.releaseHydrogen();
                    } else {
                        task.releaseOxygen();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
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
    }
}