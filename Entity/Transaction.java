import java.time.LocalDateTime;

public class Transaction{
   private int transactionId;
    private int customerId;
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    public Transaction(int transactionId, int customerId, Transaction.TransactionType type, double amount,
            LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER
}
    public int getTransactionId() {
        return transactionId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public TransactionType getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }


}
