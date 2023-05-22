package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getBalance() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal expected = new BigDecimal(100);

        // Act
        BigDecimal actual = account.getBalance();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void getBalanceNull() {
        // Arrange
        Account account = new Account(null, 10);
        BigDecimal expected = BigDecimal.ZERO;

        // Act
        BigDecimal actual = account.getBalance();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testConstructorNegativeBalance() {
        // Arrange
        int accountNumber = 10;
        BigDecimal value = new BigDecimal(-100);

        // Act & assert
        assertThrows(IllegalArgumentException.class, () -> new Account(value, accountNumber));
    }
    @Test
    void setBalance() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(50);
        BigDecimal expected = new BigDecimal(50);

        // Act
        account.setBalance(value);
        BigDecimal actual = account.getBalance();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setBalanceNegative() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(-50);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> account.setBalance(value));
    }
    @Test
    void setBalanceNull() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> account.setBalance(value));
    }
    @Test
    void getAccountNumber() {
        // Arrange
        int expected = 10;
        Account account = new Account(new BigDecimal(100), expected);

        // Act
        int actual = account.getAccountNumber();

        // Assert
        assertEquals(expected, actual);
    }
}