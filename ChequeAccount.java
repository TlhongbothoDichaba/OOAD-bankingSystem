public class ChequeAccount extends AbstractAccount {
    private final String employer; // Make final
    private final String employerAddress; // Make final
    
    public ChequeAccount(String accountNumber, double balance, String branch, 
                        Customer customer, String employer, String employerAddress) {
        super(accountNumber, balance, branch, customer);
        this.employer = employer;
        this.employerAddress = employerAddress;
    }
    
    // Getters (NO setters since fields are final)
    public String getEmployer() { return employer; }
    public String getEmployerAddress() { return employerAddress; }
    
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String getAccountType() {
        return "Cheque";
    }
    
    @Override
    public double calculateMonthlyInterest() {
        return 0; // Cheque accounts typically don't pay interest
    }
    
    @Override
    public void applyMonthlyInterest() {
        // No interest for cheque accounts
    }
}