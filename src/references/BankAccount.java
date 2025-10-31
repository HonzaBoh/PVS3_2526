package references;

public class BankAccount {
    private double balance;
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.balance = 1000;
        BankAccount b = new BankAccount();
        b.balance = 2000;
        BankAccount c = a;
        a.deposit(500);
        b.withdraw(1000);
        c.transfer(b, 500);
        b = c;
        a.balance = b.balance;
        c.deposit(1000);
        b.transfer(c, 500);
        System.out.println(a.balance);
        System.out.println(b.balance);
        System.out.println(c.balance);
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public void transfer(BankAccount other, double amount) {
        this.withdraw(amount);
        other.deposit(amount);
    }
}
