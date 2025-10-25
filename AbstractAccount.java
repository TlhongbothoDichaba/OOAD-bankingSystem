public abstract class AbstractAccount implements Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected Customer customer;
    
    public AbstractAccount(String accountNumber, double balance, String branch, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.customer = customer;
    }
    
    // Common implementation
    @Override
    public String getAccountNumber() { return accountNumber; }
    
    @Override
    public double getBalance() { return balance; }
    
    @Override
    public String getBranch() { return branch; }
    
    @Override
    public Customer getCustomer() { return customer; }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: BWP " + amount + " to account: " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // Abstract methods to be implemented by subclasses
    public abstract boolean withdraw(double amount);
    public abstract void applyMonthlyInterest();
}