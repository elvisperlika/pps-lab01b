package e1;

class CoreBankAccount {

    private final BankAccount account;
    private int balance = 0;

    public CoreBankAccount(BankAccount bankAccount) {
        this.account = bankAccount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }
}
