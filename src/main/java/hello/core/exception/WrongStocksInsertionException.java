package hello.core.exception;

public class WrongStocksInsertionException extends RuntimeException {
    public WrongStocksInsertionException() {}
    public WrongStocksInsertionException(String message) {
        super(message);
    }
}
