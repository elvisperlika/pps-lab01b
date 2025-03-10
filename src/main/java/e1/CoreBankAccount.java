package e1;

class CoreBankAccount implements BankAccount {

    protected int balance = 0;
    protected int fee = 0;

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
