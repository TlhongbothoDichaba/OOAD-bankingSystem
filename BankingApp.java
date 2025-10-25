import javafx.application.Application;
import javafx.stage.Stage;

public class BankingApp extends Application {
    private BankingSystem bank;
    private LoginController loginController;
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize the banking system with some test data
        bank = new BankingSystem();
        initializeTestData();
        
        // Create and show login view
        loginController = new LoginController(bank, primaryStage);
        loginController.showLoginView();
    }
    
    private void initializeTestData() {
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
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}