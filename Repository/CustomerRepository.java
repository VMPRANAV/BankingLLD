package Repository;
import Entity.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private final Map<Integer,Customer> customersByCustomerId=new HashMap<>();
private final Map<String, Customer> customersByAccountNo=new HashMap<>();


public Customer findByCustomerId(int customerId){
   
    return customersByCustomerId.get(customerId);
}
public Customer findByAccountNo(String accountNo){
 
    return customersByAccountNo.get(accountNo);
}
 public void save(Customer customer) {
        customersByCustomerId.put(customer.getCustomerId(), customer);
        customersByAccountNo.put(customer.getAccountNo(), customer);
    }
     public void load(String filePath) throws IOException{
        BufferedReader br= new BufferedReader(new FileReader(filePath));
        String line;
        while((line=br.readLine())!=null){
String[] data = line.split(",");

            int customerId = Integer.parseInt(data[0]);
            String accountNo = data[1];
            String name = data[2];
            double balance = Double.parseDouble(data[3]);
            String encryptedPassword = data[4];
            Customer customer= new Customer(customerId,accountNo,name,balance,encryptedPassword);
           save(customer);
        }
        br.close();
     }
         public void persist(String filePath) throws IOException {
             BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        for (Customer customer : customersByCustomerId.values()) {

            bw.write(
                    customer.getCustomerId() + "," +
                    customer.getAccountNo() + "," +
                    customer.getName() + "," +
                    customer.getBalance() + "," +
                    customer.getEncryptPassword());

            bw.newLine();
        }

        bw.close();
         }
         public List<Customer> findAll(){
            return  new ArrayList<>(customersByCustomerId.values());
         }
}
