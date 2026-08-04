public class Customer {
    private int customerId;
    private String accountNo;
    private String name;
    private double balance;
    private String encryptPassword;
    public Customer(int customerId, String accountNo, String name, double balance, String encryptPassword) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.encryptPassword = encryptPassword;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getEncryptPassword() {
        return encryptPassword;
    }
    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }
    
    public boolean deposit(double amount) {
        balance+=amount;
        return true;
    };

    public boolean withdraw(double amount) {
        balance-=amount;
        return true;
    };
}
