package e1;

public class BronzeBankAccount extends TemplateBankAccountDecorator {

    private static final int BRONZE_FEE_THRESHOLD = 100;
    private static final int FEE_UNDER_THRESHOLD = 0;
    private static final int FEE_OVER_THRESHOLD = 1;

    public BronzeBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= BRONZE_FEE_THRESHOLD) {
            this.bankAccount.withdraw(amount + FEE_UNDER_THRESHOLD);
        } else {
            this.bankAccount.withdraw((amount + FEE_OVER_THRESHOLD));
        }
    }
}
