package ourMethodv2.gpt4o;
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
        hydrogenCount.incrementAndGet();
        
        releaseHydrogen.run();
        
        if (hydrogenCount.get() == 2) {
            hydrogenCount.set(0);
            oxygenSemaphore.release();
        } else {
            hydrogenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        
        releaseOxygen.run();
        
        hydrogenSemaphore.release(2);
    }

    public static void main(String[] args) {
        Task187 waterMolecule = new Task187();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        String input1 = "HOH";
        for (char c : input1.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        waterMolecule.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else if (c == 'O') {
                new Thread(() -> {
                    try {
                        waterMolecule.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }

        String input2 = "OOHHHH";
        for (char c : input2.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        waterMolecule.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            } else if (c == 'O') {
                new Thread(() -> {
                    try {
                        waterMolecule.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}