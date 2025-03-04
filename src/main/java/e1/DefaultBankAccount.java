package e1;

public class DefaultBankAccount implements BankAccount {

    private int balance = 0;

    @Override
    public int getBalance() {
        return this.balance;
    }
}
