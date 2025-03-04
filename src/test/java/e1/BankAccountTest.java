package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void init() {
        bankAccount = new DefaultBankAccount();
    }

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, bankAccount.getBalance());
    }

}
