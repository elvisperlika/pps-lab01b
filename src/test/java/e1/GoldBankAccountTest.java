package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends TemplateBankAccountDecoratorTest {

    @BeforeEach
    void init() {
        super.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    void testWithdraw() {
        super.account.deposit(1000);
        super.account.withdraw(900);
        assertEquals(100, super.account.getBalance());
    }

    @Test
    void testWithdrawNegativeBalance() {
        super.account.deposit(1000);
        super.account.withdraw(1200);
        assertEquals(-200, super.account.getBalance());
    }

    @Test
    void testOverdraft() {
        super.account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> super.account.withdraw(1600));
    }

}
