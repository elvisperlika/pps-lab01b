package e1;

public class SilverBankAccount extends DefaultBankAccount {

    public SilverBankAccount() {
        super();
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.core.withdraw(amount + super.getFee());
    }
}
