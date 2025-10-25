public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String type; // "DEPOSIT", "WITHDRAWAL", "INTEREST"
    private double amount;
    private String date;
    private String time;
    
    public Transaction(String transactionId, String accountNumber, String type, 
                      double amount, String date, String time) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    
    @Override
    public String toString() {
        return String.format("Transaction %s: %s of BWP %.2f on %s at %s", 
                           transactionId, type, amount, date, time);
    }
}