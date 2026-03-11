package PYQ.Zoho.Advance;

import java.util.*;

public class ATMSyste {

    enum AccountType {
        SAVINGS, CURRENT
    }

    enum TransactionType {
        WITHDRAW, DEPOSIT, BALANCE, PIN_CHANGE, FAILED
    }

    // -------- ACCOUNT --------
    static class Account {
        int accountNumber;
        String holderName;
        String pin;
        double savingsBalance;
        double currentBalance;
        double dailyWithdrawn = 0;
        List<String> miniStatement = new ArrayList<>();

        Account(int accountNumber, String holderName,
                String pin, double savings,
                double current) {

            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.pin = pin;
            this.savingsBalance = savings;
            this.currentBalance = current;
        }

        double getBalance(AccountType type) {
            return (type == AccountType.SAVINGS)
                    ? savingsBalance
                    : currentBalance;
        }

        void updateBalance(AccountType type, double amount) {
            if (type == AccountType.SAVINGS)
                savingsBalance += amount;
            else
                currentBalance += amount;
        }

        void addStatement(String msg) {
            miniStatement.add(msg);
            if (miniStatement.size() > 5)
                miniStatement.remove(0);
        }
    }

    // -------- BANK --------
    static class Bank {
        Map<Integer, Account> accounts = new HashMap<>();

        void addAccount(Account acc) {
            accounts.put(acc.accountNumber, acc);
        }

        Account getAccount(int accNo) {
            return accounts.get(accNo);
        }
    }

    // -------- ATM --------
    static class ATM {

        TreeMap<Integer, Integer> cash =
                new TreeMap<>(Collections.reverseOrder());

        Bank bank;
        double totalCash = 0;
        double dailyLimit = 20000;

        ATM(Bank bank) {
            this.bank = bank;
            cash.put(2000, 0);
            cash.put(500, 0);
            cash.put(200, 0);
            cash.put(100, 0);
        }

        void loadCash(int denomination, int count) {

            if (!cash.containsKey(denomination)) {
                System.out.println("Invalid denomination.");
                return;
            }

            cash.put(denomination,
                    cash.get(denomination) + count);

            totalCash += denomination * count;

            System.out.println("Cash loaded.");
        }

        boolean authenticate(Account acc, String enteredPin) {
            return acc.pin.equals(enteredPin);
        }

        void withdraw(int accNo, String pin,
                      AccountType type,
                      int amount) {

            Account acc = bank.getAccount(accNo);

            if (acc == null) {
                System.out.println("Invalid account.");
                return;
            }

            if (!authenticate(acc, pin)) {
                System.out.println("Invalid PIN.");
                return;
            }

            if (amount % 100 != 0 || amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }

            if (amount > dailyLimit - acc.dailyWithdrawn) {
                System.out.println("Daily withdrawal limit exceeded.");
                return;
            }

            if (amount > acc.getBalance(type)) {
                System.out.println("Insufficient account balance.");
                return;
            }

            if (amount > totalCash) {
                System.out.println("ATM insufficient cash.");
                return;
            }

            Map<Integer, Integer> used =
                    dispenseNotes(amount);

            if (used == null) {
                System.out.println("Cannot dispense exact amount.");
                return;
            }

            for (int d : used.keySet()) {
                cash.put(d,
                        cash.get(d) - used.get(d));
            }

            totalCash -= amount;

            acc.updateBalance(type, -amount);
            acc.dailyWithdrawn += amount;

            acc.addStatement("Withdraw: ₹" + amount);

            System.out.println("Withdraw successful.");
        }

        Map<Integer, Integer> dispenseNotes(int amount) {

            Map<Integer, Integer> used = new HashMap<>();
            int remaining = amount;

            for (int d : cash.keySet()) {

                int available = cash.get(d);

                if (available <= 0) continue;

                int required = remaining / d;

                int take = Math.min(required, available);

                if (take > 0) {
                    used.put(d, take);
                    remaining -= take * d;
                }
            }

            if (remaining != 0)
                return null;

            return used;
        }

        void deposit(int accNo, String pin,
                     AccountType type,
                     int amount) {

            Account acc = bank.getAccount(accNo);

            if (acc == null ||
                !authenticate(acc, pin)) {

                System.out.println("Invalid credentials.");
                return;
            }

            acc.updateBalance(type, amount);
            acc.addStatement("Deposit: ₹" + amount);

            System.out.println("Deposit successful.");
        }

        void checkBalance(int accNo,
                          String pin,
                          AccountType type) {

            Account acc = bank.getAccount(accNo);

            if (acc == null ||
                !authenticate(acc, pin)) {

                System.out.println("Invalid credentials.");
                return;
            }

            System.out.println("Balance: ₹" +
                    acc.getBalance(type));
        }

        void changePin(int accNo,
                       String oldPin,
                       String newPin) {

            Account acc = bank.getAccount(accNo);

            if (acc == null ||
                !authenticate(acc, oldPin)) {

                System.out.println("Invalid PIN.");
                return;
            }

            acc.pin = newPin;
            acc.addStatement("PIN changed");

            System.out.println("PIN changed successfully.");
        }

        void miniStatement(int accNo,
                           String pin) {

            Account acc = bank.getAccount(accNo);

            if (acc == null ||
                !authenticate(acc, pin)) {

                System.out.println("Invalid credentials.");
                return;
            }

            System.out.println("Mini Statement:");
            for (String s : acc.miniStatement) {
                System.out.println(s);
            }
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Bank bank = new Bank();

        Account acc1 =
                new Account(101, "Nazim",
                        "1234", 50000, 20000);

        bank.addAccount(acc1);

        ATM atm = new ATM(bank);

        atm.loadCash(2000, 10);
        atm.loadCash(500, 20);
        atm.loadCash(100, 50);

        atm.withdraw(101, "1234",
                AccountType.SAVINGS, 3500);

        atm.deposit(101, "1234",
                AccountType.CURRENT, 2000);

        atm.checkBalance(101,
                "1234", AccountType.SAVINGS);

        atm.changePin(101,
                "1234", "5678");

        atm.miniStatement(101, "5678");
    }
}

