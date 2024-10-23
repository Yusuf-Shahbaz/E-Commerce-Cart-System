import java.text.DecimalFormat; // For formatting output to 2 decimal places
import java.util.Objects; // For validating input and checking null
 
public class PercentageDiscount implements DiscountStrategy {
    private double percentage;
 
    /**
     * Constructor to initialize the discount percentage.
     * Validates if the percentage is within 0 to 100.
     *
     * @param percentage the discount percentage to be applied
     * @throws IllegalArgumentException if the percentage is not in range [0, 100]
     */
    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.percentage = percentage;
    }
 
    /**
     * Applies the discount to the given total amount and returns the discounted value.
     *
     * @param totalAmount the total amount before discount
     * @return the total amount after the percentage discount is applied
     */
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * (1 - percentage / 100);
    }
 
    /**
     * Applies the discount and formats the result to 2 decimal places.
     *
     * @param totalAmount the total amount before discount
     * @return the discounted total formatted as a string with two decimal points
     */
    public String applyDiscountFormatted(double totalAmount) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(applyDiscount(totalAmount));
    }
 
    /**
     * Resets the discount percentage to a new value.
     * Validates if the new percentage is within 0 to 100.
     *
     * @param newPercentage the new discount percentage
     * @throws IllegalArgumentException if the percentage is not in range [0, 100]
     */
    public void setPercentage(double newPercentage) {
        if (newPercentage < 0 || newPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.percentage = newPercentage;
    }
 
    /**
     * Checks if this PercentageDiscount object is equal to another object.
     *
     * @param o the object to compare with this instance
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PercentageDiscount that = (PercentageDiscount) o;
        return Double.compare(that.percentage, percentage) == 0;
    }
 
    /**
     * Returns a hash code value for this PercentageDiscount object.
     *
     * @return a hash code based on the discount percentage
     */
    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }
 
    /**
     * Returns a string representation of the PercentageDiscount object.
     * 
     * @return a string displaying the discount percentage
     */
    @Override
    public String toString() {
        return "PercentageDiscount{" +
                "percentage=" + percentage +
                '}';
    }
 
    /**
     * Retrieves the current discount percentage.
     *
     * @return the discount percentage
     */
    public double getPercentage() {
        return percentage;
    }
}
