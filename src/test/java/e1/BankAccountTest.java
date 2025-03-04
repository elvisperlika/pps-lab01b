package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected BankAccount account;

    @BeforeEach
    void init() {
        account = new DefaultBankAccount();
    }

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, account.getBalance());
    }

}
