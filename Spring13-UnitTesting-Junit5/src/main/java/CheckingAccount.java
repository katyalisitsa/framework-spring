public class CheckingAccount {

    double balance;
    long accountNumber;
    String accountHolder;
    String type = "checking";

    public void setInfo(double pBalance, long pAccNumber, String pAccHolder) {
        balance = pBalance;
        pAccHolder = accountHolder;
        pAccNumber = accountNumber;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Error");
        }
        return balance;
    }

    public double purchase(String item, double price) {
        if (price <= balance) {
            balance -= price;
        } else {
            balance -= (price + 35);
        }
        return balance;
    }
}
