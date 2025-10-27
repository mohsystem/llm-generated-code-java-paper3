package ourMethod.claude;

import java.util.concurrent.Semaphore;

public class Task189 {
    private int n;
    private Semaphore zeroSem, evenSem, oddSem;
    private int current;
    
    public Task189(int n) {
        this.n = n;
        this.current = 1;
        this.zeroSem = new Semaphore(1);
        this.evenSem = new Semaphore(0);
        this.oddSem = new Semaphore(0);
    }
    
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if(i % 2 == 0)
                evenSem.release();
            else
                oddSem.release();
        }
    }
    
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i+=2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
    
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i+=2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] tests = {2, 5, 1, 3, 4};
        for(int n : tests) {
            System.out.println("Test case n = " + n);
            Task189 zeroEvenOdd = new Task189(n);
            
            Thread threadA = new Thread(() -> {
                try {
                    zeroEvenOdd.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread threadB = new Thread(() -> {
                try {
                    zeroEvenOdd.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread threadC = new Thread(() -> {
                try {
                    zeroEvenOdd.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            threadA.start();
            threadB.start();
            threadC.start();
            
            try {
                threadA.join();
                threadB.join();
                threadC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
        }
    }
}

interface IntConsumer {
    void accept(int x);
}
