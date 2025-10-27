package CoT.claude;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task196 {
    private int n;
    private Semaphore zeroSem, evenSem, oddSem;
    private int current;

    public Task196(int n) {
        this.n = n;
        this.current = 1;
        zeroSem = new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (current % 2 == 0) {
                evenSem.release();
            } else {
                oddSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            current++;
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            current++;
            zeroSem.release();
        }
    }

    public static void main(String[] args) {
        int[] testCases = {2, 5, 1, 3, 4};
        
        for(int n : testCases) {
            System.out.println("Test case n = " + n);
            Task196 zeo = new Task196(n);
            
            Thread t1 = new Thread(() -> {
                try {
                    zeo.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread t2 = new Thread(() -> {
                try {
                    zeo.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread t3 = new Thread(() -> {
                try {
                    zeo.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join(); 
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
        }
    }
}
