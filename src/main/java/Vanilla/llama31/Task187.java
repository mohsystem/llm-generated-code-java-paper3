package Vanilla.llama31;
import java.util.concurrent.Semaphore;

class Task187 {
    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(1);
    private final Semaphore barrier = new Semaphore(0);

    public void releaseHydrogen(Runnable releaseHydrogen) {
        hydrogenSemaphore.release();
        barrier.acquireUninterruptibly();
        releaseHydrogen.run();
    }

    public void releaseOxygen(Runnable releaseOxygen) {
        oxygenSemaphore.release();
        barrier.acquireUninterruptibly();
        releaseOxygen.run();
    }

    public void waitBarrier() {
        barrier.release(3);
    }

    public static void main(String[] args) {
        Task187 task = new Task187();
        String water = "OOHHHH";
        int n = water.length() / 3;

        for (int i = 0; i < n; i++) {
            if (water.charAt(i * 3) == 'O') {
                new Thread(() -> task.releaseOxygen(() -> System.out.print("O"))).start();
                new Thread(() -> task.releaseHydrogen(() -> System.out.print("H"))).start();
                new Thread(() -> task.releaseHydrogen(() -> System.out.print("H"))).start();
                task.waitBarrier();
            } else {
                new Thread(() -> task.releaseHydrogen(() -> System.out.print("H"))).start();
                new Thread(() -> task.releaseHydrogen(() -> System.out.print("H"))).start();
                new Thread(() -> task.releaseOxygen(() -> System.out.print("O"))).start();
                task.waitBarrier();
            }
        }
    }
}