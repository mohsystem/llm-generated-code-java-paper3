package CoT.llama31;
import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(0);

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        releaseHydrogen.run();
        if (hydrogen.availablePermits() == 0) {
            oxygen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        releaseOxygen.run();
        hydrogen.release(2);
    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
        Thread t1 = new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                h2o.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        // Test cases
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}