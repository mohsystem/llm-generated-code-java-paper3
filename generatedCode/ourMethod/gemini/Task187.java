package ourMethod.gemini;
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
            if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
                hydrogenSemaphore.release(2);
                oxygenSemaphore.release();
                hydrogenCount.set(0);
                oxygenCount.set(0);
            } else {
                lock.notifyAll();
                while(!(hydrogenCount.get() == 2 && oxygenCount.get() == 1)) {
                    lock.wait();
                }
            }

        }

        hydrogenSemaphore.acquire();


    }

    public void releaseOxygen() throws InterruptedException {

        synchronized (lock) {
            oxygenCount.incrementAndGet();
            if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
                hydrogenSemaphore.release(2);
                oxygenSemaphore.release();
                hydrogenCount.set(0);
                oxygenCount.set(0);
            } else {
                lock.notifyAll();
                while(!(hydrogenCount.get() == 2 && oxygenCount.get() == 1)) {
                    lock.wait();
                }
            }
        }

        oxygenSemaphore.acquire();

    }

    public static void main(String[] args) {
        Task187 task187 = new Task187();
        String[] inputs = {"HOH", "OOHHHH", "HOHHOH", "OHHHHO", "HHOOHH"};
        for (String input : inputs) {
            System.out.println("Input: " + input);

            int n = input.length() / 3;
            Thread[] threads = new Thread[input.length()];
            int threadIndex = 0;

            for (char c : input.toCharArray()) {
                if (c == 'H') {
                    threads[threadIndex] = new Thread(() -> {
                        try {
                            task187.releaseHydrogen();
                            System.out.print("H");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    threads[threadIndex] = new Thread(() -> {
                        try {
                            task187.releaseOxygen();
                            System.out.print("O");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
                threadIndex++;
            }
            for(Thread thread: threads) {
                thread.start();
            }
            try {
                for(Thread thread: threads) {
                    thread.join();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println();
        }
    }
}