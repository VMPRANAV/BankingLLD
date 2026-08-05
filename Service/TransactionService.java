package Service;

import Repository.*;
import Entity.*;
public class TransactionService {
private final TransactionRepository transactionRepository;
private final CustomerRepository customerRepository;
    public TransactionService(CustomerRepository customerRepository,TransactionRepository transactionRepository) {
    this.customerRepository=customerRepository;
    this.transactionRepository=transactionRepository;
    }
    public  boolean deposit (Customer customer,double amount){
        return customer.deposit(amount);


    }
    public boolean withdraw(Customer customer,double amount){
        return customer.withdraw(amount);
        }
    public boolean transfer(Customer sender, String receiverAccNo, double amount){
        Customer reciever= customerRepository.findByAccountNo(receiverAccNo);
        if(reciever==null)return false;

        return sender.withdraw(amount) && reciever.withdraw(amount);
    }

    
}
