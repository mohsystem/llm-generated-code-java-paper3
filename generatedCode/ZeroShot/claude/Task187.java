package ZeroShot.claude;

import java.util.concurrent.Semaphore;

class Task187 {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private int hydrogenCount = 0;
    
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        hydrogenCount++;
        if (hydrogenCount == 2) {
            oxygenSemaphore.release();
            hydrogenCount = 0;
        }
        barrier.acquire();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        hydrogenSemaphore.release(2);
        barrier.release(2);
    }

    public static void main(String[] args) {
        Task187 task = new Task187();
        String[] testCases = {"HOH", "OOHHHH", "HOHHHO", "OHHHHO", "HHOHOH"};
        
        for (String water : testCases) {
            System.out.println("Input: " + water);
            for (char c : water.toCharArray()) {
                if (c == 'H') {
                    new Thread(() -> {
                        try {
                            task.hydrogen(() -> System.out.print("H"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } else {
                    new Thread(() -> {
                        try {
                            task.oxygen(() -> System.out.print("O"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
            System.out.println("\n");
        }
    }
}
