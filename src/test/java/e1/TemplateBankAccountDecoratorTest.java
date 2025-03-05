package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateBankAccountDecoratorTest {

    protected BankAccount account;

    @BeforeEach
    void init() {
        account = new TemplateBankAccountDecorator(new CoreBankAccount()) {
            @Override
            public void withdraw(int amount) {
                this.bankAccount.withdraw(amount);
            }
        };
    }

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, account.getBalance());
    }

    @Test
    void testDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

}
