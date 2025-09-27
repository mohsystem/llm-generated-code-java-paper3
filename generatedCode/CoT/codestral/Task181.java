package CoT.codestral;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

public class Task181 {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;
    private final ReentrantLock lock = new ReentrantLock();

    public int openAccount(double initialBalance) {
        lock.lock();
        try {
            int accountId = nextAccountId++;
            Account account = new Account(accountId, initialBalance);
            accounts.put(accountId, account);
            return accountId;
        } finally {
            lock.unlock();
        }
    }

    public void closeAccount(int accountId) {
        lock.lock();
        try {
            Account account = accounts.get(accountId);
            if (account != null) {
                account.close();
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean deposit(int accountId, double amount) {
        lock.lock();
        try {
            Account account = accounts.get(accountId);
            if (account != null && !account.isClosed()) {
                account.deposit(amount);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(int accountId, double amount) {
        lock.lock();
        try {
            Account account = accounts.get(accountId);
            if (account != null && !account.isClosed()) {
                return account.withdraw(amount);
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance(int accountId) {
        lock.lock();
        try {
            Account account = accounts.get(accountId);
            if (account != null && !account.isClosed()) {
                return account.getBalance();
            }
            return -1;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        int account1 = bank.openAccount(1000);
        int account2 = bank.openAccount(500);

        bank.deposit(account1, 200);
        bank.withdraw(account2, 100);

        System.out.println("Account 1 balance: " + bank.getBalance(account1));
        System.out.println("Account 2 balance: " + bank.getBalance(account2));

        bank.closeAccount(account1);
        System.out.println("Account 1 balance after close: " + bank.getBalance(account1));
    }
}

class Account {
    private int accountId;
    private double balance;
    private boolean isClosed;

    public Account(int accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.isClosed = false;
    }

    public void close() {
        this.isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}