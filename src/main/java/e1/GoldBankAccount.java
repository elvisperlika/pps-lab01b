package e1;

public class GoldBankAccount extends DefaultBankAccount {

    private int minBalance = -500;

    @Override
    public void withdraw(int amount) {
        int newBalance = super.getBalance() - amount;
        if (newBalance < minBalance) {
            throw new IllegalArgumentException("This amount is not allowed, balance can't be less thant " + this.minBalance);
        }
        super.core.withdraw(amount);
    }

}
