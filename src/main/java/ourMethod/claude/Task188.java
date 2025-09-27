package ourMethod.claude;

class Task188 {
    private int n;
    private volatile boolean fooTurn = true;

    public Task188(int n) {
        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("n must be between 1 and 1000");
        }
        this.n = n;
    }

    public synchronized void foo() {
        for (int i = 0; i < n; i++) {
            while (!fooTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.print("foo");
            fooTurn = false;
            notifyAll();
        }
    }

    public synchronized void bar() {
        for (int i = 0; i < n; i++) {
            while (fooTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.print("bar");
            fooTurn = true;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 3, 5, 10};
        
        for (int testCase : testCases) {
            System.out.println("\\nTest case n = " + testCase + ":");
            final Task188 fooBar = new Task188(testCase);
            
            Thread threadA = new Thread(() -> fooBar.foo());
            Thread threadB = new Thread(() -> fooBar.bar());
            
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
