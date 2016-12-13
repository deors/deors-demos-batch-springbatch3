package deors.demos.batch.springbatch3;

/**
 * Exception class for Employee processing errors.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
public class EmployeeException
    extends Exception {

    /**
     * Serialization Id.
     */
    private static final long serialVersionUID = -8265608061550055099L;

    /**
     * Creates an exception with empty message and no root cause.
     */
    public EmployeeException() {
        super();
    }

    /**
     * Creates an exception with the given message and root cause.
     *
     * @param message the error message
     * @param cause the root cause
     */
    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates an exception with the given message and no root cause.
     *
     * @param message the error message
     */
    public EmployeeException(String message) {
        super(message);
    }

    /**
     * Creates an exception with the given root cause and no message.
     *
     * @param cause the root cause
     */
    public EmployeeException(Throwable cause) {
        super(cause);
    }
}
