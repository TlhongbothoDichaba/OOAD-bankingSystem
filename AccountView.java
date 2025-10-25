import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountView {
    private Stage stage;
    private Label accountInfoLabel;
    private Label balanceLabel;
    private TextField amountField;
    private Button depositButton;
    private Button withdrawButton;
    private Button backButton;
    private TextArea transactionsArea;
    
    public AccountView(Stage stage) {
        this.stage = stage;
        createView();
    }
    
    private void createView() {
        // Create UI components
        accountInfoLabel = new Label();
        accountInfoLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        balanceLabel = new Label();
        balanceLabel.setStyle("-fx-font-size: 14px;");
        
        amountField = new TextField();
        amountField.setPromptText("Enter amount");
        
        depositButton = new Button("Deposit");
        withdrawButton = new Button("Withdraw");
        backButton = new Button("Back to Dashboard");
        
        transactionsArea = new TextArea();
        transactionsArea.setEditable(false);
        transactionsArea.setPrefHeight(200);
        
        // Layout
        VBox mainLayout = new VBox(15);
        mainLayout.setPadding(new Insets(15));
        
        // Account info section
        VBox accountInfoBox = new VBox(5);
        accountInfoBox.getChildren().addAll(accountInfoLabel, balanceLabel);
        
        // Transaction section
        GridPane transactionGrid = new GridPane();
        transactionGrid.setHgap(10);
        transactionGrid.setVgap(10);
        transactionGrid.add(new Label("Amount:"), 0, 0);
        transactionGrid.add(amountField, 1, 0);
        
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(depositButton, withdrawButton);
        
        VBox transactionBox = new VBox(10);
        transactionBox.getChildren().addAll(
            new Label("Make Transaction:"),
            transactionGrid,
            buttonBox
        );
        
        // Transactions history
        VBox historyBox = new VBox(5);
        historyBox.getChildren().addAll(
            new Label("Transaction History:"),
            transactionsArea
        );
        
        mainLayout.getChildren().addAll(
            accountInfoBox,
            transactionBox,
            historyBox,
            backButton
        );
        
        Scene scene = new Scene(mainLayout, 500, 500);
        stage.setTitle("Banking System - Account Details");
        stage.setScene(scene);
    }
    
    // Getters
    public Label getAccountInfoLabel() { return accountInfoLabel; }
    public Label getBalanceLabel() { return balanceLabel; }
    public TextField getAmountField() { return amountField; }
    public Button getDepositButton() { return depositButton; }
    public Button getWithdrawButton() { return withdrawButton; }
    public Button getBackButton() { return backButton; }
    public TextArea getTransactionsArea() { return transactionsArea; }
    public Stage getStage() { return stage; }
    
    public void show() {
        stage.show();
    }
}