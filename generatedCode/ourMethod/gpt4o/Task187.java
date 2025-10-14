package ourMethod.openai;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Task187 {
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;
    private AtomicInteger hydrogenCount;

    public Task187() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(1);
        hydrogenCount = new AtomicInteger(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        hydrogenCount.incrementAndGet();
        if (hydrogenCount.get() == 2) {
            oxygenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        hydrogenCount.set(0);
        hydrogenSemaphore.release(2);
    }

    public static void main(String[] args) throws InterruptedException {
        Task187 h2o = new Task187();
        
        // Test case 1: HHO
        Thread t1 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t2 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t3 = new Thread(() -> {
            try { h2o.oxygen(() -> System.out.print("O")); } catch (InterruptedException e) {}
        });
        
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println();

        // Test case 2: HHOHHO
        Thread t4 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t5 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t6 = new Thread(() -> {
            try { h2o.oxygen(() -> System.out.print("O")); } catch (InterruptedException e) {}
        });
        Thread t7 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t8 = new Thread(() -> {
            try { h2o.hydrogen(() -> System.out.print("H")); } catch (InterruptedException e) {}
        });
        Thread t9 = new Thread(() -> {
            try { h2o.oxygen(() -> System.out.print("O")); } catch (InterruptedException e) {}
        });

        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
    }
}