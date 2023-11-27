package collections.exceptions;

public class NonComparableElementException extends RuntimeException {
    /**
     * Sets up this exception with an appropriate message.
     * @param collection
     */
    public NonComparableElementException(String collection) {
        super("The " + collection + " requires comparable elements.");
    }
}
