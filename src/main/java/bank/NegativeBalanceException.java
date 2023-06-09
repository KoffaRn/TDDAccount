package main.java.bank;

public class NegativeBalanceException extends RuntimeException {
    // Skulle bara visa Wakana hur man gör egna Exceptions
    public NegativeBalanceException(String message) {
        super(message);
    }
}