import javafx.stage.Stage;

public class LoginController {
    private BankingSystem bank;
    private Stage primaryStage;
    private LoginView loginView;
    private DashboardController dashboardController;
    
    public LoginController(BankingSystem bank, Stage primaryStage) {
        this.bank = bank;
        this.primaryStage = primaryStage;
        this.loginView = new LoginView(primaryStage);
        setupEventHandlers();
    }
    
    private void setupEventHandlers() {
        // Handle login button click
        loginView.getLoginButton().setOnAction(e -> handleLogin());
        
        // Handle Enter key in password field
        loginView.getPasswordField().setOnAction(e -> handleLogin());
    }
    
    private void handleLogin() {
        String username = loginView.getUsernameField().getText();
        String password = loginView.getPasswordField().getText();
        
        // Simple authentication (in real app, use proper authentication)
        if (isValidLogin(username, password)) {
            Customer customer = bank.findCustomerById("C001"); // Default to first customer
            dashboardController = new DashboardController(bank, primaryStage, customer);
            dashboardController.showDashboard();
        } else {
            loginView.getMessageLabel().setText("Invalid username or password");
        }
    }
    
    private boolean isValidLogin(String username, String password) {
        // Simple demo authentication
        return "admin".equals(username) && "password".equals(password);
    }
    
    public void showLoginView() {
        loginView.show();
    }
}