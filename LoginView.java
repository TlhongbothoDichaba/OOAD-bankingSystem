import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private Stage stage;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    
    public LoginView(Stage stage) {
        this.stage = stage;
        createView();
    }
    
    private void createView() {
        // Create UI components
        Label titleLabel = new Label("Banking System Login");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        usernameField = new TextField();
        usernameField.setPromptText("Username");
        
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        
        loginButton = new Button("Login");
        loginButton.setDefaultButton(true);
        
        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");
        
        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(new Label("Username:"), 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(new Label("Password:"), 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 1, 3);
        grid.add(messageLabel, 0, 4, 2, 1);
        
        Scene scene = new Scene(grid, 350, 250);
        stage.setTitle("Banking System - Login");
        stage.setScene(scene);
    }
    
    // Getters for controller to access
    public TextField getUsernameField() { return usernameField; }
    public PasswordField getPasswordField() { return passwordField; }
    public Button getLoginButton() { return loginButton; }
    public Label getMessageLabel() { return messageLabel; }
    public Stage getStage() { return stage; }
    
    public void show() {
        stage.show();
    }
}