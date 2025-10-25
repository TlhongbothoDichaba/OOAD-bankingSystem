public class SavingsAccount extends AbstractAccount {
    private static final double INTEREST_RATE = 0.0005; // 0.05%
    
    public SavingsAccount(String accountNumber, double balance, String branch, Customer customer) {
        super(accountNumber, balance, branch, customer);
    }
    
    @Override
    public boolean withdraw(double amount) {
        // Savings account doesn't allow withdrawals as per requirements
        System.out.println("Withdrawals not allowed from Savings account");
        return false;
    }
    
    @Override
    public String getAccountType() {
        return "Savings";
    }
    
    @Override
    public double calculateMonthlyInterest() {
        return balance * INTEREST_RATE;
    }
    
    @Override
    public void applyMonthlyInterest() {
        double interest = calculateMonthlyInterest();
        this.balance += interest;
        System.out.println("Applied monthly interest: BWP " + interest + " to account: " + accountNumber);
    }
}