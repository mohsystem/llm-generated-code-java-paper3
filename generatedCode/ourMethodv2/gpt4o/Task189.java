package ourMethodv2.gpt4o;
import java.util.concurrent.Semaphore;

class Task189 {
    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);
        
        Thread threadA = new Thread(() -> {
            try {
                zeo.zero(Task189::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        Thread threadB = new Thread(() -> {
            try {
                zeo.even(Task189::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        Thread threadC = new Thread(() -> {
            try {
                zeo.odd(Task189::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        threadA.start();
        threadB.start();
        threadC.start();
    }
    
    public static void printNumber(int number) {
        System.out.print(number);
    }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}