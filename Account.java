public interface Account {
    String getAccountNumber();
    double getBalance();
    String getBranch();
    Customer getCustomer();
    void deposit(double amount);
    boolean withdraw(double amount);
    String getAccountType();
    double calculateMonthlyInterest();
    void applyMonthlyInterest();
}