package au.net.woodberry.d2d.cafe.exception;

/**
 * A exception class thrown when a order cannot be fulfilled. It is a checked exception because we can reasonably expect
 * that the exception can be recoverable. For example, if a menu item is missing and is required to prepare an order,
 * then in such cases, a nice message would be expected to be displayed in the point of sale system.
 */
public class UnableToFulfilOrderException extends Exception {

    /**
     * @param message The exception message being thrown.
     */
    public UnableToFulfilOrderException(String message) {
        super(message);
    }
}
