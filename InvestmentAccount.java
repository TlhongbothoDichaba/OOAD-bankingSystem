public class InvestmentAccount extends AbstractAccount {
    private static final double MIN_OPENING_BALANCE = 500.00;
    private static final double INTEREST_RATE = 0.05; // 5%
    
    public InvestmentAccount(String accountNumber, double balance, String branch, Customer customer) {
        super(accountNumber, balance, branch, customer);
        if (balance < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException("Minimum opening balance for Investment account is BWP " + MIN_OPENING_BALANCE);
        }
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: BWP " + amount + " from account: " + accountNumber);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal");
            return false;
        }
    }
    
    @Override
    public String getAccountType() {
        return "Investment";
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