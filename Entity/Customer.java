package Entity;
public class Customer {
    private int customerId;
    private String accountNo;
    private String name;
    private double balance;
    private String encryptedPassword;
    public Customer(int customerId, String accountNo, String name, double balance, String encryptedPassword) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.encryptedPassword = encryptedPassword;
    }
   
    
    public int getCustomerId() {
        return customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getEncryptPassword() {
        return encryptedPassword;
    };
    //business methods
    public boolean deposit(double amount) {
        if(amount<=0)return false;
        balance+=amount;
        return true;
    };

    public boolean withdraw(double amount) {
        if(amount<=0)return false;
        if(balance-amount<1000)return false;
        balance-=amount;
        return true;
    }

}
