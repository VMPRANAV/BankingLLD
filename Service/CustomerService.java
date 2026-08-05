package Service;

import Repository.CustomerRepository;
import Entity.*;
import java.util.*;
public class CustomerService {
   private final CustomerRepository customerRepository;
       private final  EncryptionService encryptionService;
    public CustomerService(CustomerRepository customerRepository,EncryptionService encryptionService) {
  this.customerRepository=customerRepository;
     this.encryptionService=encryptionService;
    }
    public Customer registerCustomer(String name, String password, String confirmPassword){
if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        int customerId = generateCustomerId();
        String accountNo = generateAccountNumber();

        String encryptedPassword = encryptionService.encrypt(password);
        Customer customer= new Customer(customerId, accountNo, name, 10000.00, encryptedPassword);
        customerRepository.save(customer);
        return customer;

    }
    public int generateCustomerId(){
        List<Customer>customers=customerRepository.findAll();
        int maxId=100;
        for(Customer customer:customers){
            maxId=Math.max(maxId,customer.getCustomerId());
        }
return maxId+1;
    }
    public String generateAccountNumber(){
        List<Customer>customers=customerRepository.findAll();
        int maxAccNo=1000;
       
        for(Customer customer:customers){
             String accountNo= customer.getAccountNo();
             int number=Integer.parseInt(accountNo.substring(3));
          
            maxAccNo=Math.max(maxAccNo,number);
        }
        return "ACC"+String.valueOf(maxAccNo+1);
    }

    
}
