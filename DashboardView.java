import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardView {
    private Stage stage;
    private ListView<String> accountsListView;
    private Button viewAccountButton;
    private Button openAccountButton;
    private Button logoutButton;
    private Label welcomeLabel;
    
    public DashboardView(Stage stage) {
        this.stage = stage;
        createView();
    }
    
    private void createView() {
        // Create UI components
        welcomeLabel = new Label("Welcome to Banking System");
        welcomeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        accountsListView = new ListView<>();
        accountsListView.setPrefHeight(200);
        
        viewAccountButton = new Button("View Selected Account");
        openAccountButton = new Button("Open New Account");
        logoutButton = new Button("Logout");
        
        // Layout
        VBox leftPanel = new VBox(10);
        leftPanel.setPadding(new Insets(10));
        leftPanel.getChildren().addAll(
            new Label("Your Accounts:"),
            accountsListView,
            viewAccountButton,
            openAccountButton
        );
        
        VBox rightPanel = new VBox(10);
        rightPanel.setPadding(new Insets(10));
        rightPanel.getChildren().addAll(
            welcomeLabel,
            logoutButton
        );
        
        BorderPane root = new BorderPane();
        root.setLeft(leftPanel);
        root.setRight(rightPanel);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Banking System - Dashboard");
        stage.setScene(scene);
    }
    
    // Getters
    public ListView<String> getAccountsListView() { return accountsListView; }
    public Button getViewAccountButton() { return viewAccountButton; }
    public Button getOpenAccountButton() { return openAccountButton; }
    public Button getLogoutButton() { return logoutButton; }
    public Label getWelcomeLabel() { return welcomeLabel; }
    public Stage getStage() { return stage; }
    
    public void show() {
        stage.show();
    }
}