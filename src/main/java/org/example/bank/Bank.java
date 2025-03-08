package org.example.bank;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa un banco con múltiples cuentas bancarias.
 */
public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String owner, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("El número de cuenta ya está en uso.");
        }
        accounts.put(accountNumber, new BankAccount(accountNumber, owner, initialBalance));
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        BankAccount sender = accounts.get(fromAccount);
        BankAccount receiver = accounts.get(toAccount);
        if (sender == null || receiver == null) {
            return false;
        }
        sender.transfer(receiver, amount);
        return true;
    }
}
