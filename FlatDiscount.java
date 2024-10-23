import java.text.DecimalFormat; // For formatting output to 2 decimal places
import java.util.Objects; // For validating input and checking null
 
public class FlatDiscount implements DiscountStrategy {
    private double discountAmount;
 
    /**
     * Constructor to initialize the flat discount amount.
     * Validates if the discount amount is positive and reasonable (less than the total amount).
     *
     * @param discountAmount the fixed discount amount to be applied
     * @throws IllegalArgumentException if the discount amount is negative
     */
    public FlatDiscount(double discountAmount) {
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount must be positive.");
        }
        this.discountAmount = discountAmount;
    }
 
    /**
     * Applies the flat discount to the total amount.
     * Ensures the discounted total doesn't fall below zero.
     *
     * @param totalAmount the total amount before discount
     * @return the total amount after the flat discount is applied
     */
    @Override
    public double applyDiscount(double totalAmount) {
        double discountedTotal = totalAmount - discountAmount;
        return Math.max(discountedTotal, 0); // Ensures total doesn't go below zero
    }
 
    /**
     * Applies the flat discount and returns the discounted total formatted as a string.
     * The result is formatted to two decimal places.
     *
     * @param totalAmount the total amount before discount
     * @return the discounted total formatted as a string with two decimal points
     */
    public String applyDiscountFormatted(double totalAmount) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(applyDiscount(totalAmount));
    }
 
    /**
     * Resets the flat discount amount.
     * Validates if the new discount amount is positive.
     *
     * @param newDiscountAmount the new flat discount amount
     * @throws IllegalArgumentException if the discount amount is negative
     */
    public void setDiscountAmount(double newDiscountAmount) {
        if (newDiscountAmount < 0) {
            throw new IllegalArgumentException("Discount amount must be positive.");
        }
        this.discountAmount = newDiscountAmount;
    }
 
    /**
     * Retrieves the current flat discount amount.
     *
     * @return the discount amount
     */
    public double getDiscountAmount() {
        return discountAmount;
    }
 
    /**
     * Checks if this FlatDiscount object is equal to another object.
     * 
     * @param o the object to compare with this instance
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatDiscount that = (FlatDiscount) o;
        return Double.compare(that.discountAmount, discountAmount) == 0;
    }
 
    /**
     * Returns a hash code value for this FlatDiscount object.
     *
     * @return a hash code based on the discount amount
     */
    @Override
    public int hashCode() {
        return Objects.hash(discountAmount);
    }
 
    /**
     * Returns a string representation of the FlatDiscount object.
     * 
     * @return a string displaying the discount amount
     */
    @Override
    public String toString() {
        return "FlatDiscount{" +
                "discountAmount=" + discountAmount +
                '}';
    }
}
