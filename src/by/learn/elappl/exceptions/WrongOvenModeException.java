package by.learn.elappl.exceptions;

public class WrongOvenModeException extends Exception {
    public WrongOvenModeException() {
    }

    public WrongOvenModeException(String message) {
        super(message);
    }

    public WrongOvenModeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongOvenModeException(Throwable cause) {
        super(cause);
    }
}
