package e1;

public class SilverBankAccount implements BankAccount {

    private CoreBankAccount base = new CoreBankAccount(this);
    private int fee = 1;

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + this.fee);
    }
}
