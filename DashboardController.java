import javafx.stage.Stage;
import java.util.List;

public class DashboardController {
    private BankingSystem bank;
    private Stage primaryStage;
    private Customer currentCustomer;
    private DashboardView dashboardView;
    private AccountController accountController;
    
    public DashboardController(BankingSystem bank, Stage primaryStage, Customer customer) {
        this.bank = bank;
        this.primaryStage = primaryStage;
        this.currentCustomer = customer;
        this.dashboardView = new DashboardView(primaryStage);
        setupEventHandlers();
        loadCustomerAccounts();
    }
    
    private void setupEventHandlers() {
        dashboardView.getViewAccountButton().setOnAction(e -> handleViewAccount());
        dashboardView.getOpenAccountButton().setOnAction(e -> handleOpenAccount());
        dashboardView.getLogoutButton().setOnAction(e -> handleLogout());
    }
    
    private void loadCustomerAccounts() {
        dashboardView.getWelcomeLabel().setText("Welcome, " + currentCustomer.getFirstName() + " " + currentCustomer.getSurname());
        
        List<Account> accounts = bank.getCustomerAccounts(currentCustomer.getCustomerId());
        dashboardView.getAccountsListView().getItems().clear();
        
        for (Account account : accounts) {
            String accountInfo = String.format("%s Account: %s - Balance: BWP %.2f", 
                account.getAccountType(), account.getAccountNumber(), account.getBalance());
            dashboardView.getAccountsListView().getItems().add(accountInfo);
        }
    }
    
    private void handleViewAccount() {
        String selected = dashboardView.getAccountsListView().getSelectionModel().getSelectedItem();
        if (selected != null) {
            // Extract account number from selection
            String accountNumber = selected.split(": ")[1].split(" -")[0];
            Account account = bank.findAccountByNumber(accountNumber);
            
            accountController = new AccountController(bank, primaryStage, account);
            accountController.showAccountView();
        }
    }
    
    private void handleOpenAccount() {
        // Implementation for opening new account
        System.out.println("Open new account functionality");
    }
    
    private void handleLogout() {
        LoginController loginController = new LoginController(bank, primaryStage);
        loginController.showLoginView();
    }
    
    public void showDashboard() {
        dashboardView.show();
    }
}