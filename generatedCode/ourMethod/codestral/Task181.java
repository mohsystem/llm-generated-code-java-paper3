package ourMethod.codestral;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final int id;
    private double balance;
    private boolean isOpen;
    private Lock lock;

    public BankAccount(int id) {
        this.id = id;
        this.balance = 0;
        this.isOpen = true;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            balance -= amount;
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

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, BankAccount> accounts = new ConcurrentHashMap<>();
        BankAccount account1 = new BankAccount(1);
        accounts.put(1, account1);
        account1.deposit(100);
        account1.withdraw(50);
        System.out.println(account1.getBalance());
        account1.close();
        try {
            account1.deposit(100);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}