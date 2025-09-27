package ourMethod.gemini;
import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {

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

        public synchronized void deposit(BigDecimal amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    throw new IllegalStateException("Account is closed.");
                }
                if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException("Deposit amount must be positive.");
                }
                balance = balance.add(amount);
            } finally {
                lock.unlock();
            }
        }

        public synchronized BigDecimal withdraw(BigDecimal amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    throw new IllegalStateException("Account is closed.");
                }
                if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException("Withdrawal amount must be positive.");
                }
                if (balance.compareTo(amount) < 0) {
                    throw new IllegalArgumentException("Insufficient balance.");
                }
                balance = balance.subtract(amount);
                return amount;
            } finally {
                lock.unlock();
            }

        }


        public synchronized BigDecimal getBalance() {
            lock.lock();
            try {
                if (!isOpen) {
                    throw new IllegalStateException("Account is closed.");
                }
                return balance;
            } finally {
                lock.unlock();
            }
        }


        public synchronized void close() {
            lock.lock();
            try {
                if (!isOpen) {
                    throw new IllegalStateException("Account is already closed.");
                }
                isOpen = false;
            } finally {
                lock.unlock();
            }
        }

        public synchronized int getAccountNumber(){
            return accountNumber;
        }
    }


    public static void main(String[] args) {
        Account account1 = new Account(1);
        account1.deposit(BigDecimal.valueOf(100));
        System.out.println("Balance:" + account1.getBalance());
        account1.withdraw(BigDecimal.valueOf(50));
        System.out.println("Balance:" + account1.getBalance());

        Account account2 = new Account(2);
        account2.deposit(BigDecimal.valueOf(500.25));
        System.out.println("AccountNumber:" + account2.getAccountNumber() + ", Balance:" + account2.getBalance());
        account2.close();


        Account account3 = new Account(3);
        account3.deposit(BigDecimal.valueOf(1500));
        System.out.println("Balance:" + account3.getBalance());

        Account account4 = new Account(4);
        account4.deposit(BigDecimal.valueOf(10000));
        System.out.println("Balance:" + account4.getBalance());
        account4.withdraw(BigDecimal.valueOf(2000));
        System.out.println("Balance:" + account4.getBalance());


        Account account5 = new Account(5);
        account5.deposit(BigDecimal.valueOf(2342.32));
        System.out.println("Balance:" + account5.getBalance());
        account5.close();

    }
}