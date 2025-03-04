package e1;

public class DefaultBankAccount implements BankAccount {

    private int balance = 0;

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }
}
