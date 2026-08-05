package Service;

import Entity.Customer;
import Repository.*;
public class AuthenticationService {
    CustomerRepository customerRepository;
      EncryptionService encryptionService;
    public AuthenticationService(CustomerRepository customerRepository,EncryptionService encryptionService) {
     this.customerRepository=customerRepository;
     this.encryptionService=encryptionService;
    }

    public Customer authenticate(int customerId, String password){
        Customer customer=customerRepository.findByCustomerId(customerId);
         if (customer == null)
            return null;
        String inputEncryptPassword=encryptionService.encrypt(password);
        if(inputEncryptPassword.equals(customer.getEncryptPassword())) return customer;
        return null;
    }
}
