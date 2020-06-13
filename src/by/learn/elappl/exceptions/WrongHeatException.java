package by.learn.elappl.exceptions;

public class WrongHeatException extends Exception {
    public WrongHeatException() {
    }

    public WrongHeatException(String message) {
        super(message);
    }

    public WrongHeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongHeatException(Throwable cause) {
        super(cause);
    }
}
