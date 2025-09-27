package Vanilla.gemini;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

class Task187 {

    private Semaphore hydrogenSemaphore = new Semaphore(0);
    private Semaphore oxygenSemaphore = new Semaphore(0);
    private CyclicBarrier barrier = new CyclicBarrier(3);
    private AtomicInteger hydrogenCount = new AtomicInteger(0);
    private AtomicInteger oxygenCount = new AtomicInteger(0);
    private StringBuilder molecule = new StringBuilder();


    public void releaseHydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenCount.incrementAndGet();
        if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
            hydrogenSemaphore.release(2);
            oxygenSemaphore.release();
        }
       hydrogenSemaphore.acquire();
        molecule.append("H");

        try {
            barrier.await();
        } catch (Exception e) {

        }

        
    }

    public void releaseOxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenCount.incrementAndGet();
        if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
            hydrogenSemaphore.release(2);
            oxygenSemaphore.release();
        }
        oxygenSemaphore.acquire();
        molecule.append("O");

        try {
            barrier.await();
        } catch (Exception e) {

        }

    }

    public String getMolecule() {
        hydrogenCount.set(0);
        oxygenCount.set(0);
        String result = molecule.toString();
        molecule.setLength(0);
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        Task187 task = new Task187();
        String[] inputs = {"HOH", "OOHHHH", "HOHHOH", "OHH", "HHHHOO"};
        String[] expectedOutputs = {"HHO", "HHOHHO", "HHOHHO", "HHO", "HHHOHO"};

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expectedOutput = expectedOutputs[i];
            Thread[] threads = new Thread[input.length()];

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == 'H') {
                    threads[j] = new Thread(() -> {
                        try {
                            task.releaseHydrogen(() -> {});
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    threads[j] = new Thread(() -> {
                        try {
                            task.releaseOxygen(() -> {});
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
                threads[j].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }
            String actualOutput = task.getMolecule();
            System.out.println("Input: " + input + ", Expected: " + expectedOutput + ", Actual: " + actualOutput);
            assert actualOutput.equals(expectedOutput) : "Test case " + (i + 1) + " failed";

        }


    }
}