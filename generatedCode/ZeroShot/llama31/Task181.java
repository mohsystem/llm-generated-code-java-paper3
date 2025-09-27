package ZeroShot.llama31;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    public static class BankAccount {
        private double balance;
        private boolean isOpen = true;
        private final Lock lock = new ReentrantLock();

        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }

        public void open() {
            lock.lock();
            try {
                isOpen = true;
            } finally {
                lock.unlock();
            }
        }

        public void close() {
            lock.lock();
            try {
                isOpen = false;
            } finally {
                lock.unlock();
            }
        }

        public void deposit(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    System.out.println("Account is closed. Deposit failed.");
                    return;
                }
                balance += amount;
                System.out.println("Deposit: " + amount);
                System.out.println("Balance after deposit: " + balance);
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    System.out.println("Account is closed. Withdrawal failed.");
                    return;
                }
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawal: " + amount);
                    System.out.println("Balance after withdrawal: " + balance);
                } else {
                    System.out.println("Insufficient funds. Withdrawal cancelled.");
                }
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000);

            Thread depositThread = new Thread(() -> account.deposit(500));
            Thread withdrawalThread = new Thread(() -> account.withdraw(200));
            Thread closeThread = new Thread(() -> account.close());

            depositThread.start();
            withdrawalThread.start();
            closeThread.start();

            try {
                depositThread.join();
                withdrawalThread.join();
                closeThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            account.deposit(100); // This should fail because the account is closed
        }
    }
}