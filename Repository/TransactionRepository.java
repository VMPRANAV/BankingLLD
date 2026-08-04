package Repository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entity.Customer;
import Entity.Transaction;
import Entity.TransactionType;
public class TransactionRepository {
    private final Map<Integer, List<Transaction>> transactionsByCustomerId
        = new HashMap<>();
 public void save(Transaction transaction){
    transactionsByCustomerId.computeIfAbsent(transaction.getCustomerId(),k->new ArrayList<>()).add(transaction);
 }
 public void load(String filePath) throws IOException{
        BufferedReader br= new BufferedReader(new FileReader(filePath));
        String line;
        while((line=br.readLine())!=null){
String[] data = line.split(",");

             int transactionId = Integer.parseInt(data[0]);
            int customerId = Integer.parseInt(data[1]);
            TransactionType type=TransactionType.valueOf(data[2]);
            double amount = Double.parseDouble(data[3]);
            LocalDateTime timestamp=LocalDateTime.parse(data[4]);


         Transaction transaction= new Transaction(transactionId,customerId,type,amount,timestamp);
           save(transaction);
        }
        br.close();
     }
      public void persist(String filePath) throws IOException {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

        for (List<Transaction> transactions : transactionsByCustomerId.values()) {

            for (Transaction transaction : transactions) {

                bw.write(
                        transaction.getTransactionId() + "," +
                        transaction.getCustomerId() + "," +
                        transaction.getType() + "," +
                        transaction.getAmount() + "," +
                        transaction.getTimestamp()
                );

                bw.newLine();
            }
        }
    }
}
}
