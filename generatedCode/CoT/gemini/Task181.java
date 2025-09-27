package CoT.gemini;
import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {

    private static class Account {
        private final int accountNumber;
        private BigDecimal balance;
        private boolean isOpen;
        private final ReentrantLock lock = new ReentrantLock();

        public Account(int accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = BigDecimal.ZERO;
            this.isOpen = true;
        }

        public synchronized boolean isOpen() {
            return isOpen;
        }

        public synchronized void close() {
            this.isOpen = false;
        }

        public synchronized BigDecimal getBalance() {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            return balance;
        }


        public synchronized void deposit(BigDecimal amount) {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            lock.lock();
            try {
                balance = balance.add(amount);
            } finally {
                lock.unlock();
            }

        }

        public synchronized void withdraw(BigDecimal amount) {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (balance.compareTo(amount) < 0) {
                throw new IllegalArgumentException("Insufficient funds.");
            }

            lock.lock();
            try {
                balance = balance.subtract(amount);
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        Account account1 = new Account(12345);

        // Test cases
        account1.deposit(new BigDecimal("100.00"));
        System.out.println("Balance after deposit: " + account1.getBalance()); // Expected: 100.00

        account1.withdraw(new BigDecimal("50.00"));
        System.out.println("Balance after withdrawal: " + account1.getBalance()); // Expected: 50.00

        account1.close();


        try {
            account1.deposit(new BigDecimal("25.00"));
        } catch (IllegalStateException e) {
            System.out.println("Deposit to closed account failed as expected: " + e.getMessage());
        }


        Account account2 = new Account(67890);
        account2.deposit(new BigDecimal("500.00"));
        System.out.println("Balance of account2: " + account2.getBalance());

        try {
            account2.withdraw(new BigDecimal("600.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal exceeding balance failed as expected: " + e.getMessage());
        }

        account2.withdraw(new BigDecimal("200.00"));
        System.out.println("Balance after withdrawal: " + account2.getBalance());
    }
}