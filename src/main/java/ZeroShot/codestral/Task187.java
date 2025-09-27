package ZeroShot.codestral;
import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore hydrogen;
    private Semaphore oxygen;
    private Semaphore barrier;

    public H2O() {
        hydrogen = new Semaphore(2);
        oxygen = new Semaphore(0);
        barrier = new Semaphore(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        barrier.acquire();
        releaseHydrogen.run();
        barrier.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        barrier.acquire();
        releaseOxygen.run();
        hydrogen.release(2);
        barrier.release(2);
    }
}