package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank sut = new Bank();
    @Test
    void deposit() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(100);
        BigDecimal expected = new BigDecimal(200);

        // Act
        BigDecimal actual = sut.deposit(value, account);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void depositNullAmount() {
        // Arrange
        BigDecimal expected = new BigDecimal(100);
        Account account = new Account(expected, 10);

        // Act
        BigDecimal actual = sut.deposit(null, account);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void depositNullAccount() {
        // Arrange
        BigDecimal value = new BigDecimal(100);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sut.deposit(value, null));
    }
    @Test
    void depositNegativeAmount() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(-100);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sut.deposit(value, account));
    }
    @Test
    void withdraw() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(50);
        BigDecimal expected = new BigDecimal(50);

        // Act
        BigDecimal actual = sut.withdraw(value, account);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void withdrawNullAmount() {
        // Arrange
        BigDecimal expected = new BigDecimal(100);
        Account account = new Account(expected, 10);

        // Act
        BigDecimal actual = sut.withdraw(null, account);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void withdrawNegativeAmount() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(-100);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sut.withdraw(value, account));
    }
    @Test
    void withdrawNullAccount() {
        // Arrange
        BigDecimal value = new BigDecimal(100);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sut.withdraw(value, null));
    }
    @Test
    void withdrawTooLargeAmount() {
        // Arrange
        Account account = new Account(new BigDecimal(100), 10);
        BigDecimal value = new BigDecimal(1000);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> sut.withdraw(value, account));
    }
}