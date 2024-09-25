package Hw1.Exe5;
// bài tập thuộc Project P-1.30 sách M.Goodrich, trang 57
public class CreditCard {
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public boolean charge(double price) {
        if (price + balance > limit) {
            return false; // vượt giới hạn
        }
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }
}
