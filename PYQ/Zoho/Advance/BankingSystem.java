package PYQ.Zoho.Advance;
// BankingSystem
import java.util.*;
// Design and implement a console-based Banking System that supports:

// Creating accounts

// Depositing money

// Withdrawing money

// Transferring money between accounts

// Viewing account details

// Viewing transaction history

// All data must be stored in memory.

// 📦 Assumptions

// Each account has:

// Account Number (unique)

// Account Holder Name

// Balance

// Transaction history

// Rules:

// Initial deposit ≥ 0

// Withdrawal only if sufficient balance

// Transfer only if both accounts exist

// Every transaction must be recorded

// No negative balances allowed

public class BankingSystem {

    // -------- TRANSACTION --------
    static class Transaction {
        String type;
        double amount;
        String description;

        Transaction(String type, double amount, String description) {
            this.type = type;
            this.amount = amount;
            this.description = description;
        }

        void print() {
            System.out.println(type + " | Amount: ₹" + amount +
                    " | " + description);
        }
    }

    // -------- ACCOUNT --------
    static class Account {
        int accountNumber;
        String name;
        double balance;
        List<Transaction> history = new ArrayList<>();

        Account(int accountNumber, String name, double initialDeposit) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = initialDeposit;
        }

        void deposit(double amount) {
            balance += amount;
            history.add(new Transaction("DEPOSIT", amount,
                    "Money deposited"));
        }

        boolean withdraw(double amount) {
            if (balance < amount) {
                return false;
            }
            balance -= amount;
            history.add(new Transaction("WITHDRAW", amount,
                    "Money withdrawn"));
            return true;
        }

        void printDetails() {
            System.out.println("Account No: " + accountNumber);
            System.out.println("Name: " + name);
            System.out.println("Balance: ₹" + balance);
        }

        void printHistory() {
            if (history.isEmpty()) {
                System.out.println("No transactions.");
                return;
            }

            for (Transaction t : history) {
                t.print();
            }
        }
    }

    // -------- BANK --------
    static class Bank {

        Map<Integer, Account> accounts = new HashMap<>();

        // Create account
        void createAccount(int accNo, String name, double initialDeposit) {

            if (accounts.containsKey(accNo)) {
                System.out.println("Account number already exists.");
                return;
            }

            if (initialDeposit < 0) {
                System.out.println("Initial deposit cannot be negative.");
                return;
            }

            Account acc = new Account(accNo, name, initialDeposit);
            accounts.put(accNo, acc);

            System.out.println("Account created successfully.");
        }

        // Deposit
        void deposit(int accNo, double amount) {

            Account acc = accounts.get(accNo);

            if (acc == null) {
                System.out.println("Account not found.");
                return;
            }

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }

            acc.deposit(amount);
            System.out.println("Deposit successful.");
        }

        // Withdraw
        void withdraw(int accNo, double amount) {

            Account acc = accounts.get(accNo);

            if (acc == null) {
                System.out.println("Account not found.");
                return;
            }

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }

            if (!acc.withdraw(amount)) {
                System.out.println("Insufficient balance.");
                return;
            }

            System.out.println("Withdrawal successful.");
        }

        // Transfer
        void transfer(int fromAcc, int toAcc, double amount) {

            Account sender = accounts.get(fromAcc);
            Account receiver = accounts.get(toAcc);

            if (sender == null || receiver == null) {
                System.out.println("Invalid account number.");
                return;
            }

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }

            if (sender.balance < amount) {
                System.out.println("Insufficient balance.");
                return;
            }

            sender.balance -= amount;
            receiver.balance += amount;

            sender.history.add(new Transaction("TRANSFER OUT",
                    amount, "Transferred to Acc " + toAcc));

            receiver.history.add(new Transaction("TRANSFER IN",
                    amount, "Received from Acc " + fromAcc));

            System.out.println("Transfer successful.");
        }

        // View account
        void viewAccount(int accNo) {

            Account acc = accounts.get(accNo);

            if (acc == null) {
                System.out.println("Account not found.");
                return;
            }

            acc.printDetails();
        }

        // View transaction history
        void viewHistory(int accNo) {

            Account acc = accounts.get(accNo);

            if (acc == null) {
                System.out.println("Account not found.");
                return;
            }

            acc.printHistory();
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.createAccount(101, "Nazim", 5000);
        bank.createAccount(102, "John", 3000);

        bank.deposit(101, 2000);
        bank.withdraw(102, 1000);

        bank.transfer(101, 102, 1500);

        bank.viewAccount(101);
        bank.viewHistory(101);

        bank.viewAccount(102);
        bank.viewHistory(102);
    }
}
