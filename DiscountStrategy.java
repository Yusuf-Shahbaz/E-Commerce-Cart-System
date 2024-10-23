import java.util.function.DoubleUnaryOperator;
 
/**
 * Functional interface for applying a discount strategy.
 * Allows different implementations of discounts to be used on the total cart amount.
 */
@FunctionalInterface
public interface DiscountStrategy {
 
    /**
     * Applies a discount to the given total amount.
     * 
     * @param totalAmount The original total amount before applying the discount.
     * @return The amount after applying the discount.
     */
    double applyDiscount(double totalAmount);
 
    /**
     * Combines two discount strategies into one. The result of the first discount is passed to the second.
     * 
     * @param other The second discount strategy to apply.
     * @return A combined discount strategy.
     */
    default DiscountStrategy combineWith(DiscountStrategy other) {
        return totalAmount -> other.applyDiscount(this.applyDiscount(totalAmount));
    }
 
    /**
     * Applies a discount and caps it at a maximum discount value.
     * 
     * @param maxDiscount The maximum allowable discount.
     * @return A discount strategy with a cap on the discount value.
     */
    default DiscountStrategy withMaxDiscount(double maxDiscount) {
        return totalAmount -> {
            double discountedAmount = this.applyDiscount(totalAmount);
            return Math.max(totalAmount - maxDiscount, discountedAmount);
        };
    }
 
    /**
     * Creates a DiscountStrategy from a standard Java function (DoubleUnaryOperator).
     * 
     * @param operator The function defining the discount.
     * @return A new DiscountStrategy.
     */
    static DiscountStrategy from(DoubleUnaryOperator operator) {
        return operator::applyAsDouble;
    }
 
    /**
     * Provides a no-discount strategy. The total amount remains unchanged.
     * 
     * @return A no-discount DiscountStrategy.
     */
    static DiscountStrategy noDiscount() {
        return totalAmount -> totalAmount;
    }
 
    /**
     * Provides a fixed percentage discount strategy.
     * 
     * @param percentage The percentage discount (e.g., 10 for 10%).
     * @return A percentage-based DiscountStrategy.
     */
    static DiscountStrategy percentageDiscount(double percentage) {
        return totalAmount -> totalAmount * (1 - percentage / 100);
    }
 
    /**
     * Provides a fixed amount discount strategy.
     * 
     * @param amount The fixed discount amount to subtract.
     * @return A fixed amount-based DiscountStrategy.
     */
    static DiscountStrategy fixedAmountDiscount(double amount) {
        return totalAmount -> totalAmount - amount;
    }
}
