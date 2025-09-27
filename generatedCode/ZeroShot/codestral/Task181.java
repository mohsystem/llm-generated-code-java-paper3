package ZeroShot.codestral;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    private ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void openAccount(int id) {
        accounts.put(id, new Account());
    }

    public void closeAccount(int id) {
        accounts.remove(id);
    }

    public void deposit(int id, double amount) {
        Account account = accounts.get(id);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(int id, double amount) {
        Account account = accounts.get(id);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    private class Account {
        private double balance;
        private Lock lock = new ReentrantLock();

        public void deposit(double amount) {
            lock.lock();
            try {
                balance += amount;
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(double amount) {
            lock.lock();
            try {
                if (balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient funds");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        bank.openAccount(1);
        bank.deposit(1, 1000);
        bank.withdraw(1, 500);
        bank.closeAccount(1);
        bank.deposit(1, 100); // This should print "Account not found"
    }
}