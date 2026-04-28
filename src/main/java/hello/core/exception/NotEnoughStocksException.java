package hello.core.exception;

public class NotEnoughStocksException extends RuntimeException {
    public NotEnoughStocksException() {}
    public NotEnoughStocksException(String message) {
        super(message);
    }
}
