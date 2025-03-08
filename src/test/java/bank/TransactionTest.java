package bank;

import org.example.bank.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest
{
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction("Depósito", 500);
    }

    @Test
    void testGetType() {
        assertEquals("Depósito", transaction.getType());
    }

    @Test
    void testGetAmount() {
        assertEquals(500, transaction.getAmount());
    }

    @Test
    void testGetTimestamp() {
        assertEquals(transaction.getTimestamp(), transaction.getTimestamp());
    }
}
