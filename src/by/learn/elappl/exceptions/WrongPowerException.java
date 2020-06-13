package by.learn.elappl.exceptions;

public class WrongPowerException extends Exception {
    public WrongPowerException() {
    }

    public WrongPowerException(String message) {
        super(message);
    }

    public WrongPowerException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPowerException(Throwable cause) {
        super(cause);
    }
}
