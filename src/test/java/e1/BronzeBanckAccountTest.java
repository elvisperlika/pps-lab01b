package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBanckAccountTest extends TemplateBankAccountDecoratorTest {

    @BeforeEach
    void init() {
        super.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    void testWithdrawAmountUnderThreshold() {
        super.account.deposit(200);
        super.account.withdraw(100);
        assertEquals(100, super.account.getBalance());
    }

    @Test
    void testWithDrawAmountOverThreshold() {
        super.account.deposit(200);
        super.account.withdraw(101);
        assertEquals(98, super.account.getBalance());
    }

}
