package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    public int initialAccountNumber = 123456789;
    public BigDecimal initialBalance = new BigDecimal(Integer.MAX_VALUE);
    Account sut;
    @BeforeEach
    void setUp() {
        sut = new Account(initialBalance, initialAccountNumber);
    }
    @Test
    void getBalance() {
        // Act
        BigDecimal actual = sut.getBalance();

        // Assert
        assertEquals(initialBalance, actual);
    }
    @Test
    void getBalanceWrongSum() {
        // arrange
        BigDecimal expected = new BigDecimal(200);

        // act
        BigDecimal actual = sut.getBalance();

        // assert
        assertNotEquals(expected, actual);
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
        BigDecimal value = new BigDecimal(-100);

        // Act & assert
        assertThrows(NegativeBalanceException.class, () -> new Account(value, initialAccountNumber));
    }
    @Test
    void getAccountNumber() {
        // Arrange
        int expected = initialAccountNumber;

        // Act
        int actual = sut.getAccountNumber();

        // Assert
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0, 110, 222.25, 300.44112, 4677.213, 500, 65661, 7, 8, 9})
    void testDeposit(double testValue) {
        // Arrange
        BigDecimal value = new BigDecimal(testValue);
        sut.deposit(value);
        BigDecimal expected = value.add(initialBalance);

        // Act
        BigDecimal actual = sut.getBalance();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testDepositNull() {
        // Arrange
        BigDecimal expected = initialBalance;

        // Act
        BigDecimal actual = sut.deposit(null);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testDepositNegative() {
        // Arrange
        BigDecimal value = new BigDecimal(-100);

        // Act & assert
        assertThrows(IllegalArgumentException.class, () -> sut.deposit(value));
    }
    @ParameterizedTest
    @ValueSource(doubles = {0, 110, 222.25, 300.44112, 4677.213, 500, 65661, 7, 8, 9})
    void testWithdraw(double testValue) {
        // Arrange
        BigDecimal value = new BigDecimal(testValue);
        sut.withdraw(value);
        BigDecimal expected = initialBalance.subtract(value);

        // Act
        BigDecimal actual = sut.getBalance();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testWithdrawNull() {
        // Arrange
        BigDecimal expected = initialBalance;

        // Act
        BigDecimal actual = sut.withdraw(null);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testWithdrawNegative() {
        // Arrange
        BigDecimal value = new BigDecimal(-100);

        // Act & assert
        assertThrows(IllegalArgumentException.class, () -> sut.withdraw(value));
    }
    @Test
    void testWithdrawTooMuch() {
        // Arrange
        BigDecimal value = initialBalance.add(BigDecimal.ONE);

        // Act & assert
        assertThrows(NegativeBalanceException.class, () -> sut.withdraw(value));
    }
    @Test
    void testWithdrawAll() {
        // Arrange
        BigDecimal value = initialBalance;

        // Act
        BigDecimal actual = sut.withdraw(value);

        // Assert
        assertEquals(BigDecimal.ZERO, actual);
    }
}