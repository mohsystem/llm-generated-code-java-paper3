package CoT.claude;

import java.util.concurrent.Semaphore;

public class Task187 {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private int hydrogenCount = 0;
    
    public synchronized void releaseHydrogen() {
        try {
            hydrogenSemaphore.acquire();
            System.out.print("H");
            hydrogenCount++;
            if (hydrogenCount == 2) {
                barrier.release();
                hydrogenCount = 0;
            }
            barrier.acquire();
            hydrogenSemaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void releaseOxygen() {
        try {
            oxygenSemaphore.acquire();
            System.out.print("O");
            barrier.release();
            barrier.acquire();
            oxygenSemaphore.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void formWater(String water) {
        for(char c : water.toCharArray()) {
            if(c == 'H') {
                new Thread(() -> releaseHydrogen()).start();
            } else {
                new Thread(() -> releaseOxygen()).start();
            }
        }
    }

    public static void main(String[] args) {
        Task187 solution = new Task187();
        
        // Test case 1
        System.out.println("\\nTest case 1: HOH");
        solution.formWater("HOH");
        
        // Test case 2 
        System.out.println("\\nTest case 2: OOHHHH");
        solution.formWater("OOHHHH");
        
        // Test case 3
        System.out.println("\\nTest case 3: HOHHHO");
        solution.formWater("HOHHHO");
        
        // Test case 4
        System.out.println("\\nTest case 4: OHOHH");
        solution.formWater("OHOHH");
        
        // Test case 5
        System.out.println("\\nTest case 5: HHOHHO");
        solution.formWater("HHOHHO");
    }
}
