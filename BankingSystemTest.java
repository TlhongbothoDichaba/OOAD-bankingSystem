public class BankingSystemTest {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create customers
        IndividualCustomer tlhongbotho = new IndividualCustomer("C001", "Tlhongbotho", "Dichaba", "123 Main St");
        IndividualCustomer alicia = new IndividualCustomer("C002", "Alicia", "Kgabiso", "456 Oak Ave");
        
        bank.addCustomer(tlhongbotho);
        bank.addCustomer(alicia);
        
        // Create accounts
        SavingsAccount tlhongbothoSavings = new SavingsAccount("SA001", 1000.00, "Main Branch", tlhongbotho);
        InvestmentAccount tlhongbothoInvestment = new InvestmentAccount("IA001", 500.00, "Main Branch", tlhongbotho);
        ChequeAccount aliciaCheque = new ChequeAccount("CA001", 2000.00, "Downtown Branch", 
                                                   alicia, "Tech Corp", "789 Business Park");
        
        bank.addAccount(tlhongbothoSavings);
        bank.addAccount(tlhongbothoInvestment);
        bank.addAccount(aliciaCheque);
        
        // Test transactions
        System.out.println("=== Testing Deposits ===");
        tlhongbothoSavings.deposit(500.00);
        bank.recordTransaction("SA001", "DEPOSIT", 500.00, "2025-09-19", "10:00:00");
        
        aliciaCheque.deposit(1000.00);
        bank.recordTransaction("CA001", "DEPOSIT", 1000.00, "2025-09-19", "10:15:00");
        
        System.out.println("\n=== Testing Withdrawals ===");
        tlhongbothoInvestment.withdraw(200.00);
        bank.recordTransaction("IA001", "WITHDRAWAL", 200.00, "2025-09-19", "10:30:00");
        
        aliciaCheque.withdraw(500.00);
        bank.recordTransaction("CA001", "WITHDRAWAL", 500.00, "2025-09-19", "10:45:00");
        
        // Try to withdraw from savings (should fail)
        tlhongbothoSavings.withdraw(100.00);
        
        System.out.println("\n=== Testing Interest Calculation ===");
        System.out.println("Tlhongbotho's Savings Interest: BWP " + tlhongbothoSavings.calculateMonthlyInterest());
        System.out.println("Tlhongbotho's Investment Interest: BWP " + tlhongbothoInvestment.calculateMonthlyInterest());
        System.out.println("Alicia's Cheque Interest: BWP " + aliciaCheque.calculateMonthlyInterest());
        
        System.out.println("\n=== Applying Monthly Interest ===");
        bank.applyMonthlyInterestToAllAccounts();
        
        System.out.println("\n=== Final Balances ===");
        System.out.println("Tlhongbotho's Savings Balance: BWP " + tlhongbothoSavings.getBalance());
        System.out.println("Tlhongbotho's Investment Balance: BWP " + tlhongbothoInvestment.getBalance());
        System.out.println("Alicia's Cheque Balance: BWP " + aliciaCheque.getBalance());
        
        System.out.println("\n=== Tlhongbotho's Accounts ===");
        java.util.List<Account> tlhongbothosAccounts = bank.getCustomerAccounts("C001");
        for (Account acc : tlhongbothosAccounts) {
            System.out.println(acc.getAccountType() + " Account: " + acc.getAccountNumber() + 
                             " - Balance: BWP " + acc.getBalance());
        }
        
        System.out.println("\n=== All Transactions ===");
        java.util.List<Transaction> allTransactions = bank.getTransactions();
        for (Transaction txn : allTransactions) {
            System.out.println(txn);
        }
    }
}