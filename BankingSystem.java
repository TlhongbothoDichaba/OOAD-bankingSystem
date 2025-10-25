import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    private final List<Customer> customers; // Make final
    private final List<Account> accounts;   // Make final
    private final List<Transaction> transactions; // Make final
    
    public BankingSystem() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    
    // Customer management
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    // Account management
    public void addAccount(Account account) {
        accounts.add(account);
    }
    
    // Transaction recording
    public void recordTransaction(String accountNumber, String type, double amount, String date, String time) {
        String transactionId = "TXN" + System.currentTimeMillis();
        Transaction transaction = new Transaction(transactionId, accountNumber, type, amount, date, time);
        transactions.add(transaction);
    }
    
    // Search methods
    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    public List<Account> getCustomerAccounts(String customerId) {
        List<Account> customerAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getCustomer().getCustomerId().equals(customerId)) {
                customerAccounts.add(account);
            }
        }
        return customerAccounts;
    }
    
    public List<Transaction> getAccountTransactions(String accountNumber) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }
    
    // Apply monthly interest to all applicable accounts - FIXED METHOD CALL
    public void applyMonthlyInterestToAllAccounts() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount || account instanceof InvestmentAccount) {
                account.applyMonthlyInterest(); // This should work now
                recordTransaction(account.getAccountNumber(), "INTEREST", 
                                account.calculateMonthlyInterest(), 
                                java.time.LocalDate.now().toString(),
                                java.time.LocalTime.now().toString());
            }
        }
    }
    
    // Getters for testing
    public List<Customer> getCustomers() { return customers; }
    public List<Account> getAccounts() { return accounts; }
    public List<Transaction> getTransactions() { return transactions; }
}


