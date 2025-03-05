package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends TemplateBankAccountDecoratorTest {

    private static final int SILVER_FEE = 1;

    @BeforeEach
    void init(){
        super.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testWithdraw() {
        super.account.deposit(1000);
        super.account.withdraw(200);
        assertEquals(799, super.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        super.account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> super.account.withdraw(1200));
    }

}
