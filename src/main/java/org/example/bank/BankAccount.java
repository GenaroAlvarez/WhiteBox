package org.example.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cuenta bancaria con operaciones de depósito, retiro y transferencia.
 */
public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, String owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
        }
        balance += amount;
        transactions.add(new Transaction("Depósito", amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        balance -= amount;
        transactions.add(new Transaction("Retiro", amount));
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("La cuenta de destino no puede ser nula.");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
        transactions.add(new Transaction("Transferencia a " + targetAccount.getOwner(), amount));
        targetAccount.getTransactions().add(new Transaction("Transferencia recibida de " + this.getOwner(), amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
