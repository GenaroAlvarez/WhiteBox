package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.example.bank.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", "Juan Pérez", 1000.0);
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0),
                "El monto a depositar debe ser mayor a cero."
        );
    }

    @Test
    void testWithdraw() {
        account.withdraw(100);
        assertEquals(900, account.getBalance());
    }

    @Test
    void testWithdrawInvalidAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0),
                "El monto a retirar debe ser mayor a cero."
        );
    }

    @Test
    void testWithdrawInsufficientAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(10000),
                "Fondos insuficientes."
        );
    }

    @Test
    void testTransfer() {
        BankAccount targetAccount = new BankAccount("154325", "Genaro Alvarez", 2000);
        account.transfer(targetAccount, 100);
        assertEquals(900, account.getBalance());
        assertEquals(2100, targetAccount.getBalance());
    }

    @Test
    void testTransferNullTargetAccount() {
        BankAccount targetAccount = null;
        assertThrows(
                IllegalArgumentException.class,
                () -> account.transfer(targetAccount, 100),
                "La cuenta de destino no puede ser nula."
        );
    }
}

