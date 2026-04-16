package hello.core.exception;

public class WrongStocksInsertionException extends RuntimeException {
    public WrongStocksInsertionException(String message) {
        super(message);
    }
}
