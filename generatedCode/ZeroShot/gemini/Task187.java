package ZeroShot.gemini;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Task187 {

    private Semaphore hydrogenSemaphore = new Semaphore(0);
    private Semaphore oxygenSemaphore = new Semaphore(0);
    private AtomicInteger hydrogenCount = new AtomicInteger(0);
    private AtomicInteger oxygenCount = new AtomicInteger(0);
    private final Object lock = new Object();


    public void releaseHydrogen() throws InterruptedException {
        synchronized (lock) {
            hydrogenCount.incrementAndGet();
            if (hydrogenCount.get() >= 2 && oxygenCount.get() >= 1) {
                hydrogenSemaphore.release(2);
                oxygenSemaphore.release();
                hydrogenCount.set(0);
                oxygenCount.set(0);
            } else {
                lock.notifyAll();
            }
        }

        hydrogenSemaphore.acquire();
        // Bind with oxygen and another hydrogen
        System.out.print("H");
    }

    public void releaseOxygen() throws InterruptedException {
        synchronized (lock) {
            oxygenCount.incrementAndGet();
            if (hydrogenCount.get() >= 2 && oxygenCount.get() >= 1) {
                hydrogenSemaphore.release(2);
                oxygenSemaphore.release();
                hydrogenCount.set(0);
                oxygenCount.set(0);
            }  else {
                lock.notifyAll();
            }
        }

        oxygenSemaphore.acquire();
        // Bind with two hydrogens
        System.out.print("O");
    }

    public static void main(String[] args) {
        Task187 task = new Task187();
        String[] testCases = {"HOH", "OOHHHH", "HOHHOH", "OHHHHO", "HHOOHH"};

        for (String testCase : testCases) {
            Thread[] threads = new Thread[testCase.length()];
            for (int i = 0; i < testCase.length(); i++) {
                char c = testCase.charAt(i);
                if (c == 'H') {
                    final int index = i;
                    threads[i] = new Thread(() -> {
                        try {
                            task.releaseHydrogen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    final int index = i;
                    threads[i] = new Thread(() -> {
                        try {
                            task.releaseOxygen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

            for (Thread thread : threads) {
                thread.start();
            }
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }

    }
}