package bank;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private final int accountNumber;
    public Account(BigDecimal balance, int accountNumber) throws IllegalArgumentException {
        if(balance == null) balance = BigDecimal.ZERO;
        if(balance.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot have negative balance");
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    protected void setBalance(BigDecimal balance) throws IllegalArgumentException {
        if(balance == null) throw new IllegalArgumentException("Balance cannot be null");
        if(balance.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot have negative balance");
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}