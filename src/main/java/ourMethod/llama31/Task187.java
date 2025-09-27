package ourMethod.llama31;
import java.util.concurrent.Semaphore;

class Task187 {
    private Semaphore oxygenSemaphore = new Semaphore(0);
    private Semaphore hydrogenSemaphore = new Semaphore(0);
    private int hydrogenCount = 0;

    public Task187() {}

    public void releaseHydrogen() throws InterruptedException {
        hydrogenCount++;
        if (hydrogenCount == 2) {
            oxygenSemaphore.release();
            hydrogenSemaphore.release();
            hydrogenSemaphore.release();
            hydrogenCount = 0;
        } else {
            hydrogenSemaphore.acquire();
        }
    }

    public void releaseOxygen() throws InterruptedException {
        oxygenSemaphore.acquire();
        System.out.print("O");
    }

    public static void main(String[] args) throws InterruptedException {
        Task187 task = new Task187();
        Thread oxygenThread = new Thread(() -> {
            try {
                task.releaseOxygen();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread hydrogenThread = new Thread(() -> {
            try {
                task.releaseHydrogen();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Test cases
        for (char c : "HOH".toCharArray()) {
            if (c == 'H') {
                hydrogenThread.start();
            } else {
                oxygenThread.start();
            }
        }

        for (char c : "OOHHHH".toCharArray()) {
            if (c == 'H') {
                hydrogenThread.start();
            } else {
                oxygenThread.start();
            }
        }
    }
}