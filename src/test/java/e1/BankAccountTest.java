package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    protected BankAccount account;

    @BeforeEach
    void init() {
        account = new DefaultBankAccount();
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

    @Test
    void testWithdraw() {
        account.deposit(1000);
        account.withdraw(999);
        assertEquals(1, account.getBalance());
    }

}
