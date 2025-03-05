package e1;

public class SilverBankAccount extends TemplateBankAccountDecorator {

    private static final int SILVER_MIN_BALANCE = 0;

    public SilverBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if ((super.getBalance() - amount) < SILVER_MIN_BALANCE) {
            throw new IllegalArgumentException();
        }
        this.bankAccount.withdraw(amount);
    }
}
