package e1;

public abstract class TemplateBankAccountDecorator implements BankAccount {

    protected final BankAccount bankAccount;

    public TemplateBankAccountDecorator(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.bankAccount.deposit(amount);
    }

    @Override
    public abstract void withdraw(int amount);

}
