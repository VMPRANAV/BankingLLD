package Entity;
import java.time.LocalDateTime;

public class Transaction{
   private final int transactionId;
    private final int customerId;
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime timestamp;
    public Transaction(int transactionId, int customerId, TransactionType type, double amount,
            LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
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
