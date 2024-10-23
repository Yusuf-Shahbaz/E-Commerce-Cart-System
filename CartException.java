import java.time.LocalDateTime; // For logging the time the exception occurred
import java.util.Objects; // For checking null values and enhancing equality checks
 
public class CartException extends Exception {
    private LocalDateTime timestamp;
 
    /**
     * Constructor that accepts a message and records the timestamp when the exception was created.
     *
     * @param message the error message associated with this exception
     */
    public CartException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now(); // Automatically records the time of the exception
    }
 
    /**
     * Constructor that accepts a message and a cause (another throwable).
     * This is useful for exception chaining, where one exception leads to another.
     *
     * @param message the error message associated with this exception
     * @param cause the cause of this exception (another exception)
     */
    public CartException(String message, Throwable cause) {
        super(message, cause);
        this.timestamp = LocalDateTime.now(); // Automatically records the time of the exception
    }
 
    /**
     * Returns the time when the exception was thrown.
     *
     * @return the timestamp when this exception was created
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
 
    /**
     * Provides a formatted error message that includes the timestamp.
     * This method can be useful for logging purposes.
     *
     * @return a formatted string including the exception message and the time it occurred
     */
    public String getDetailedMessage() {
        return String.format("CartException occurred at %s: %s", timestamp, getMessage());
    }
 
    /**
     * Returns a string representation of this CartException.
     * Includes the message and the time of the exception.
     *
     * @return a string representation of the exception
     */
    @Override
    public String toString() {
        return "CartException{" +
                "message='" + getMessage() + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
 
    /**
     * Checks if this CartException is equal to another object.
     * It considers both the message and the timestamp of the exception.
     *
     * @param o the object to compare to this exception
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartException)) return false;
        CartException that = (CartException) o;
        return Objects.equals(getMessage(), that.getMessage()) &&
               Objects.equals(timestamp, that.timestamp);
    }
 
    /**
     * Returns a hash code for this CartException object.
     * The hash code is based on the message and the timestamp.
     *
     * @return a hash code value for this exception
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), timestamp);
    }
}
