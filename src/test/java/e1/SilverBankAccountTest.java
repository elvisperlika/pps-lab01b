package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends DefaultBankAccountTest {

    @BeforeEach
    void init(){
        super.account = new SilverBankAccount();
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
        assertThrows(IllegalStateException.class, () -> super.account.withdraw(1200));
    }

}
