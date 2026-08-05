import Repository.CustomerRepository;
import Repository.TransactionRepository;
import Service.*;

class Main{
    public static void main(String []args){
          CustomerRepository customerRepository = new CustomerRepository();
    TransactionRepository transactionRepository = new TransactionRepository();
    EncryptionService encryptionService = new EncryptionService();
    AuthenticationService authenticationService =
            new AuthenticationService(customerRepository, encryptionService);
    CustomerService customerService= new CustomerService(customerRepository,encryptionService);
      TransactionService transactionService =
            new TransactionService(customerRepository, transactionRepository);

    }
}