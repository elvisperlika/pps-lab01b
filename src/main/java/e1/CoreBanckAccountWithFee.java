package e1;

public class CoreBanckAccountWithFee extends CoreBankAccount {

    private final int fee;

    public CoreBanckAccountWithFee(int fee) {
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.balance = super.balance - (amount + this.fee);
    }
}
