package e1;

public class BronzeBankAccount extends TemplateBankAccountDecorator {

    public BronzeBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {

    }
}
