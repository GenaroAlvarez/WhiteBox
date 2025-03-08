package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.example.bank.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void testCreateAccount() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        assertNotNull(bank.getAccount("12345"));
    }

    @Test
    void testCreateAccountWithExistingAccountNumber() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> bank.createAccount("12345", "Genaro Alvarez", 2000.0),
                "El número de cuenta ya está en uso."
        );
    }

    @Test
    void testTransfer() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        bank.createAccount("54231", "Genaro Alvarez", 2000.0);
        assertTrue(bank.transfer("12345", "54231", 500.0));
    }

    @Test
    void testTransferWithFromAccountNull() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        bank.createAccount("54231", "Genaro Alvarez", 2000.0);
        assertFalse(bank.transfer("", "54231", 500.0));
    }

    @Test
    void testTransferWithToAccountNull() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        bank.createAccount("54231", "Genaro Alvarez", 2000.0);
        assertFalse(bank.transfer("12345", "", 500.0));
    }

    @Test
    void testTransferWithFromAndToAccountNull() {
        bank.createAccount("12345", "Juan Pérez", 1000.0);
        bank.createAccount("54231", "Genaro Alvarez", 2000.0);
        assertFalse(bank.transfer("", "", 500.0));
    }
}
