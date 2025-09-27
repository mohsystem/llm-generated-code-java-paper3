package Vanilla.codestral;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    private ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void openAccount(int accountId) {
        accounts.putIfAbsent(accountId, new Account());
    }

    public void closeAccount(int accountId) {
        accounts.computeIfPresent(accountId, (k, v) -> v.close() ? null : v);
    }

    public boolean deposit(int accountId, int amount) {
        Account account = accounts.get(accountId);
        return account != null && account.deposit(amount);
    }

    public boolean withdraw(int accountId, int amount) {
        Account account = accounts.get(accountId);
        return account != null && account.withdraw(amount);
    }

    private static class Account {
        private AtomicInteger balance = new AtomicInteger(0);
        private AtomicBoolean isOpen = new AtomicBoolean(true);
        private ReentrantLock lock = new ReentrantLock();

        public boolean deposit(int amount) {
            if (isOpen.get()) {
                balance.addAndGet(amount);
                return true;
            }
            return false;
        }

        public boolean withdraw(int amount) {
            lock.lock();
            try {
                if (isOpen.get() && balance.get() >= amount) {
                    balance.addAndGet(-amount);
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }

        public boolean close() {
            return isOpen.compareAndExchange(true, false);
        }
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        bank.openAccount(1);
        bank.deposit(1, 100);
        bank.withdraw(1, 50);
        bank.closeAccount(1);
        // Add more test cases here
    }
}