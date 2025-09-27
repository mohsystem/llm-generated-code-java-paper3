package ZeroShot.llama31;
import java.util.concurrent.Semaphore;

class Task187 {
    private Semaphore hydrogenSemaphore = new Semaphore(0);
    private Semaphore oxygenSemaphore = new Semaphore(0);
    private int hydrogenCount = 0;

    public Task187() {}

    public void releaseHydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        hydrogenCount++;
        if (hydrogenCount == 2) {
            oxygenSemaphore.release();
            hydrogenSemaphore.release();
            hydrogenSemaphore.release();
            hydrogenCount = 0;
        }
    }

    public void releaseOxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        hydrogenSemaphore.release();
        hydrogenSemaphore.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Task187 task = new Task187();
        String water = "HOH";
        for (char c : water.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        task.releaseHydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else {
                new Thread(() -> {
                    try {
                        task.releaseOxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}