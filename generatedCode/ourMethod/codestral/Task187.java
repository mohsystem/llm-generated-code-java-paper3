package ourMethod.codestral;
import java.util.concurrent.Semaphore;

public class Task187 {
    private Semaphore hydrogen = new Semaphore(2);
    private Semaphore oxygen = new Semaphore(0);

    public void releaseHydrogen() throws InterruptedException {
        hydrogen.acquire();
        System.out.print("H");
        if (hydrogen.availablePermits() == 0 && oxygen.hasQueuedThreads()) {
            oxygen.release(2);
        }
    }

    public void releaseOxygen() throws InterruptedException {
        oxygen.acquire(2);
        System.out.print("O");
        hydrogen.release(2);
    }

    public static void main(String[] args) {
        Task187 h2o = new Task187();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    h2o.releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    h2o.releaseOxygen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}