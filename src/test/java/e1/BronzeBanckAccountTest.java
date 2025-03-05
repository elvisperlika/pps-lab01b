package e1;

import org.junit.jupiter.api.BeforeEach;

public class BronzeBanckAccountTest extends TemplateBankAccountDecoratorTest {

    @BeforeEach
    void init() {
        super.account = new BronzeBankAccount(new CoreBankAccount());
    }

}
