package main.java.bank;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private final int accountNumber;
    // NegativeBalanceException, skulle bara visa Wakana hur man gör egna exception types :)

    public Account(BigDecimal balance, int accountNumber) throws NegativeBalanceException {
        // Null balance = 0
        if(balance == null) balance = BigDecimal.ZERO;
        // Negative balance = exception
        if(balance.compareTo(BigDecimal.ZERO) < 0) throw new NegativeBalanceException("Cannot have negative balance");
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal deposit(BigDecimal value) throws IllegalArgumentException {
        // Null value = no change
        if(value == null) return balance;
        // Negative value = exception
        if(value.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot deposit negative amount");
        balance = balance.add(value);
        return balance;
    }
    public BigDecimal withdraw(BigDecimal value) throws IllegalArgumentException, NegativeBalanceException {
        // Null value = no change
        if(value == null) return balance;
        // Negative value = exception
        if(value.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot withdraw negative amount");
        // Withdraw more than balance = exception
        if(value.compareTo(balance) > 0) throw new NegativeBalanceException("Cannot withdraw more than balance");
        balance = balance.subtract(value);
        return balance;
    }
}