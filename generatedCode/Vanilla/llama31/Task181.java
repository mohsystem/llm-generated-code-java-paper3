package Vanilla.llama31;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private boolean isOpen;
    private Lock lock;

    public BankAccount() {
        balance = 0.0;
        isOpen = true;
        lock = new ReentrantLock();
    }

    public void openAccount() {
        lock.lock();
        try {
            if (!isOpen) {
                System.out.println("Account is already open.");
                return;
            }
            isOpen = true;
            System.out.println("Account opened successfully.");
        } finally {
            lock.unlock();
        }
    }

    public void closeAccount() {
        lock.lock();
        try {
            if (!isOpen) {
                System.out.println("Account is already closed.");
                return;
            }
            isOpen = false;
            System.out.println("Account closed successfully.");
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (!isOpen) {
                System.out.println("Account is closed. Cannot deposit.");
                return;
            }
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Balance after deposit: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (!isOpen) {
                System.out.println("Account is closed. Cannot withdraw.");
                return;
            }
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
                System.out.println("Balance after withdrawal: " + balance);
            } else {
                System.out.println("Insufficient funds. Withdrawal cancelled.");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class Task181 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Test cases
        account.openAccount();
        account.deposit(1000);
        account.withdraw(500);
        account.closeAccount();
        account.withdraw(500); // Should fail because account is closed
        account.openAccount(); // Should fail because account is already closed
    }
}