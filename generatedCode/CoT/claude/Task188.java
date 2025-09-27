package CoT.claude;

public class Task188 {
    private int n;
    private boolean fooTurn = true;
    
    public Task188(int n) {
        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("n must be between 1 and 1000");
        }
        this.n = n;
    }
    
    public synchronized void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooTurn) {
                wait();
            }
            System.out.print("foo");
            fooTurn = false;
            notifyAll();
        }
    }
    
    public synchronized void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (fooTurn) {
                wait();
            }
            System.out.print("bar");
            fooTurn = true;
            notifyAll();
        }
    }
    
    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 5, 10};
        
        for (int test : testCases) {
            System.out.println("\\nTest case n = " + test);
            final Task188 fooBar = new Task188(test);
            
            Thread threadA = new Thread(() -> {
                try {
                    fooBar.foo();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            Thread threadB = new Thread(() -> {
                try {
                    fooBar.bar();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            threadA.start();
            threadB.start();
            
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
