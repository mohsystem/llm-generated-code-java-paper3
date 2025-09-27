package ourMethod.claude;

import java.util.concurrent.Semaphore;

class Task187 {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private volatile int hydrogenCount = 0;
    private final Object lock = new Object();
    private StringBuilder result = new StringBuilder();

    public void hydrogen() throws InterruptedException {
        hydrogenSemaphore.acquire();
        synchronized(lock) {
            hydrogenCount++;
            result.append("H");
            if (hydrogenCount == 2) {
                hydrogenCount = 0;
                barrier.release();
            }
        }
        barrier.acquire();
        hydrogenSemaphore.release();
    }

    public void oxygen() throws InterruptedException {
        oxygenSemaphore.acquire();
        result.append("O");
        barrier.release();
        barrier.acquire();
        oxygenSemaphore.release();
    }

    public String buildWater(String water) throws InterruptedException {
        result = new StringBuilder();
        Thread[] threads = new Thread[water.length()];
        
        for (int i = 0; i < water.length(); i++) {
            final int index = i;
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        hydrogen();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        oxygen();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        
        return result.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Task187 task = new Task187();
        String[] testCases = {"HOH", "OOHHHH", "HOHHHO", "OHHHHO", "HHOHOH"};
        
        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + task.buildWater(test));
            System.out.println();
        }
    }
}
