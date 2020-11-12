package Exceptions;

public class BadURLException extends Exception {

    public BadURLException(String msg) {
        super(msg);
    }

    public BadURLException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
