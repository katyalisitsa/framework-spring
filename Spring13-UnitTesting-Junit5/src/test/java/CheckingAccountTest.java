import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount();
        checkingAccount.setInfo(100, 2345345L, "Kate");
    }

    @Test
    void deposit() {
        assertEquals(200, checkingAccount.deposit(100));
    }

    @Test
    void withdraw() {
    }

    @Test
    void purchase() {
    }
}