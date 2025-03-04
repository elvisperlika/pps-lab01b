package e1;

public class DefaultBankAccount implements BankAccount {

    private int balance = 0;
    private final CoreBankAccount core;

    public DefaultBankAccount() {
        this.core = new CoreBankAccount(this);
    }

    @Override
    public int getBalance() {
        return this.core.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.core.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.core.withdraw(amount);
    }
}
