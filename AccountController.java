import javafx.stage.Stage;
import java.util.List;

public class AccountController {
    private BankingSystem bank;
    private Stage primaryStage;
    private Account currentAccount;
    private AccountView accountView;
    private DashboardController dashboardController;
    
    public AccountController(BankingSystem bank, Stage primaryStage, Account account) {
        this.bank = bank;
        this.primaryStage = primaryStage;
        this.currentAccount = account;
        this.accountView = new AccountView(primaryStage);
        setupEventHandlers();
        loadAccountData();
    }
    
    private void setupEventHandlers() {
        accountView.getDepositButton().setOnAction(e -> handleDeposit());
        accountView.getWithdrawButton().setOnAction(e -> handleWithdrawal());
        accountView.getBackButton().setOnAction(e -> handleBackToDashboard());
    }
    
    private void loadAccountData() {
        // Set account information
        accountView.getAccountInfoLabel().setText(
            currentAccount.getAccountType() + " Account: " + currentAccount.getAccountNumber()
        );
        
        accountView.getBalanceLabel().setText(
            "Current Balance: BWP " + String.format("%.2f", currentAccount.getBalance())
        );
        
        // Load transaction history
        loadTransactionHistory();
    }
    
    private void loadTransactionHistory() {
        List<Transaction> transactions = bank.getAccountTransactions(currentAccount.getAccountNumber());
        StringBuilder history = new StringBuilder();
        
        for (Transaction txn : transactions) {
            history.append(txn.toString()).append("\n");
        }
        
        accountView.getTransactionsArea().setText(history.toString());
    }
    
    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(accountView.getAmountField().getText());
            if (amount > 0) {
                currentAccount.deposit(amount);
                bank.recordTransaction(currentAccount.getAccountNumber(), "DEPOSIT", amount,
                    java.time.LocalDate.now().toString(),
                    java.time.LocalTime.now().toString());
                updateAccountDisplay();
                accountView.getAmountField().clear();
            } else {
                System.out.println("Invalid deposit amount");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
        }
    }
    
    private void handleWithdrawal() {
        try {
            double amount = Double.parseDouble(accountView.getAmountField().getText());
            if (amount > 0) {
                boolean success = currentAccount.withdraw(amount);
                if (success) {
                    bank.recordTransaction(currentAccount.getAccountNumber(), "WITHDRAWAL", amount,
                        java.time.LocalDate.now().toString(),
                        java.time.LocalTime.now().toString());
                }
                updateAccountDisplay();
                accountView.getAmountField().clear();
            } else {
                System.out.println("Invalid withdrawal amount");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
        }
    }
    
    private void updateAccountDisplay() {
        accountView.getBalanceLabel().setText(
            "Current Balance: BWP " + String.format("%.2f", currentAccount.getBalance())
        );
        loadTransactionHistory();
    }
    
    private void handleBackToDashboard() {
        Customer customer = currentAccount.getCustomer();
        dashboardController = new DashboardController(bank, primaryStage, customer);
        dashboardController.showDashboard();
    }
    
    public void showAccountView() {
        accountView.show();
    }
}