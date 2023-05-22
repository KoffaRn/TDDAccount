package bank;

import java.math.BigDecimal;

public class Bank {
    public BigDecimal deposit(BigDecimal amount, Account account) throws IllegalArgumentException {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount == null) amount = BigDecimal.ZERO;
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cannot deposit negative amount");
        account.setBalance(account.getBalance().add(amount));
        return account.getBalance();
    }

    public BigDecimal withdraw(BigDecimal amount, Account account) throws IllegalArgumentException {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount == null) amount = BigDecimal.ZERO;
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        account.setBalance(account.getBalance().subtract(amount));
        return account.getBalance();
    }

}