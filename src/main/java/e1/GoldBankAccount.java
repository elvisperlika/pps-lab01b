package e1;

public class GoldBankAccount extends TemplateBankAccountDecorator {

    private static final int GOLD_MIN_BALANCE = -500;

    public GoldBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if ((super.getBalance() - amount) < GOLD_MIN_BALANCE) {
            throw new IllegalArgumentException();
        }
        this.bankAccount.withdraw(amount);
    }

}
