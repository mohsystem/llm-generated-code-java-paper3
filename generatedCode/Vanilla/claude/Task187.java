package Vanilla.claude;

import java.util.concurrent.Semaphore;

class Task187 {
    private Semaphore hydrogen = new Semaphore(2);
    private Semaphore oxygen = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private int hydrogenCount = 0;
    private int oxygenCount = 0;

    public void releaseHydrogen() throws InterruptedException {
        hydrogen.acquire();
        synchronized(this) {
            hydrogenCount++;
            if (hydrogenCount == 2 && oxygenCount == 1) {
                hydrogenCount = 0;
                oxygenCount = 0;
                barrier.release(3);
            }
        }
        barrier.acquire();
        System.out.print("H");
        hydrogen.release();
    }

    public void releaseOxygen() throws InterruptedException {
        oxygen.acquire();
        synchronized(this) {
            oxygenCount++;
            if (hydrogenCount == 2 && oxygenCount == 1) {
                hydrogenCount = 0;
                oxygenCount = 0;
                barrier.release(3);
            }
        }
        barrier.acquire();
        System.out.print("O");
        oxygen.release();
    }

    public static void main(String[] args) {
        String[] testCases = {"HOH", "OOHHHH", "HOHHHO", "OHHHHO", "HHOHOH"};
        Task187 task = new Task187();
        
        for (String water : testCases) {
            System.out.println("\\nInput: " + water);
            System.out.print("Output: ");
            
            Thread[] threads = new Thread[water.length()];
            for (int i = 0; i < water.length(); i++) {
                final char c = water.charAt(i);
                if (c == 'H') {
                    threads[i] = new Thread(() -> {
                        try {
                            task.releaseHydrogen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    threads[i] = new Thread(() -> {
                        try {
                            task.releaseOxygen();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
                threads[i].start();
            }
            
            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
