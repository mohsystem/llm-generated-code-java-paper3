package CoT.codestral;
import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        oxygenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(2);
        releaseOxygen.run();
        hydrogenSemaphore.release(2);
    }
}