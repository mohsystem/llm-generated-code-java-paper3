package CoT.llama31;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    public static class BankAccount {
        private double balance;
        private boolean isOpen;
        private final Lock lock;

        public BankAccount(double initialBalance) {
            balance = initialBalance;
            isOpen = true;
            lock = new ReentrantLock();
        }

        public void open() {
            lock.lock();
            try {
                if (!isOpen) {
                    isOpen = true;
                    System.out.println("Account opened.");
                } else {
                    System.out.println("Account is already open.");
                }
            } finally {
                lock.unlock();
            }
        }

        public void close() {
            lock.lock();
            try {
                if (isOpen) {
                    isOpen = false;
                    System.out.println("Account closed.");
                } else {
                    System.out.println("Account is already closed.");
                }
            } finally {
                lock.unlock();
            }
        }

        public void deposit(double amount) {
            lock.lock();
            try {
                if (isOpen) {
                    balance += amount;
                    System.out.println("Deposited: " + amount);
                    System.out.println("Balance after deposit: " + balance);
                } else {
                    System.out.println("Operation failed: Account is closed.");
                }
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(double amount) {
            lock.lock();
            try {
                if (isOpen) {
                    if (balance >= amount) {
                        balance -= amount;
                        System.out.println("Withdrawn: " + amount);
                        System.out.println("Balance after withdrawal: " + balance);
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                } else {
                    System.out.println("Operation failed: Account is closed.");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        // Test cases
        account.open();
        account.deposit(500.0);
        account.withdraw(200.0);
        account.close();
        account.withdraw(100.0); // Should fail
        account.open();
        account.deposit(300.0);
    }
}