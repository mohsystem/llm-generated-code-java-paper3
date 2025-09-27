package ourMethod.claude;

class Task196 {
    private static class ZeroEvenOdd {
        private int n;
        private int state = 0; // 0: print zero, 1: print odd, 2: print even
        private int currentNumber = 1;

        public ZeroEvenOdd(int n) {
            if (n < 1 || n > 1000) {
                throw new IllegalArgumentException("n must be between 1 and 1000");
            }
            this.n = n;
        }

        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
            while (currentNumber <= n) {
                if (state != 0) {
                    wait();
                    continue;
                }
                printNumber.accept(0);
                state = (currentNumber % 2 == 0) ? 2 : 1;
                notifyAll();
            }
        }

        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
            while (currentNumber <= n) {
                if (state != 2) {
                    wait();
                    continue;
                }
                printNumber.accept(currentNumber);
                currentNumber++;
                state = 0;
                notifyAll();
            }
        }

        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
            while (currentNumber <= n) {
                if (state != 1) {
                    wait();
                    continue;
                }
                printNumber.accept(currentNumber);
                currentNumber++;
                state = 0;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {2, 5, 1, 3, 4};
        for (int n : testCases) {
            System.out.println("Test case n = " + n);
            ZeroEvenOdd zeo = new ZeroEvenOdd(n);
            Thread threadA = new Thread(() -> {
                try {
                    zeo.zero(System.out::print);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            Thread threadB = new Thread(() -> {
                try {
                    zeo.even(System.out::print);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            Thread threadC = new Thread(() -> {
                try {
                    zeo.odd(System.out::print);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
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
                Thread.currentThread().interrupt();
            }
            System.out.println();
        }
    }
}
