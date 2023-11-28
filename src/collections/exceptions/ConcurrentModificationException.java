package collections.exceptions;

public class ConcurrentModificationException extends RuntimeException {

    /**
     * Creates an exception with no message.
     */
    public ConcurrentModificationException() {
        super();
    }

    /**
     * Creates an exception with the specified message.
     * @param message the message to be displayed when the exception is thrown
     */
    public ConcurrentModificationException(String message) {
        super(message);
    }
}
