package ZeroShot.claude;

import java.util.concurrent.Semaphore;

class Task189 {
    private int n;
    private Semaphore zeroSem, evenSem, oddSem;
    private int current;

    public Task189(int n) {
        this.n = n;
        this.zeroSem = new Semaphore(1);
        this.evenSem = new Semaphore(0);
        this.oddSem = new Semaphore(0);
        this.current = 1;
    }

    public void zero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSem.acquire();
            System.out.print(0);
            if (current % 2 == 0)
                evenSem.release();
            else
                oddSem.release();
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            System.out.print(i);
            current++;
            zeroSem.release();
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            System.out.print(i);
            current++;
            zeroSem.release();
        }
    }

    public static void main(String[] args) {
        int[] testCases = {2, 5, 1, 3, 4};
        
        for (int test : testCases) {
            System.out.println("\\nTest case n = " + test + ":");
            Task189 zeo = new Task189(test);
            
            Thread threadA = new Thread(() -> {
                try {
                    zeo.zero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread threadB = new Thread(() -> {
                try {
                    zeo.even();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread threadC = new Thread(() -> {
                try {
                    zeo.odd();
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
        }
    }
}
