package ourMethod.llama31;
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

        public void deposit(double amount) {
            lock.lock();
            try {
                if (isOpen) {
                    balance += amount;
                    System.out.println("Deposited: " + amount);
                    System.out.println("Balance after deposit: " + balance);
                } else {
                    System.out.println("Account is closed.");
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
                    System.out.println("Account is closed.");
                }
            } finally {
                lock.unlock();
            }
        }

        public void closeAccount() {
            lock.lock();
            try {
                isOpen = false;
                System.out.println("Account closed.");
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000);

            Thread depositThread = new Thread(() -> account.deposit(500));
            Thread withdrawalThread = new Thread(() -> account.withdraw(200));
            Thread closeThread = new Thread(() -> account.closeAccount());

            depositThread.start();
            withdrawalThread.start();
            closeThread.start();
        }
    }
}