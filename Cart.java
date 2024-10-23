import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.Serializable;
 
public class Cart implements Serializable {
    private List<Product> products = new ArrayList<>();
    
    public Cart(){
        this.products = new ArrayList<>();
    }
    /**
     * Gets the list of products in the cart.
     * @return A list of Product objects.
     */
    public List<Product> getProducts() {
        return products;
    }
    
    /**
     * Adds a product to the cart.
     * @param product The Product object to add.
     * @throws IllegalArgumentException if the product is null.
     */
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }
 
    /**
     * Removes a product from the cart.
     * @param product The Product object to remove.
     * @throws IllegalArgumentException if the product is not in the cart.
     */
    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException("Product is not in the cart");
        }
        products.remove(product);
    }
 
    /**
     * Finds a product in the cart by its ID.
     * @param id The ID of the product.
     * @return An Optional containing the Product if found, or empty if not found.
     */
    public Optional<Product> findProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
 
    /**
     * Calculates the total price of all products in the cart.
     * @return Total price of products in the cart.
     */
    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
 
    /**
     * Applies a discount to all products in the cart.
     * @param discountRate Discount rate in percentage (0-100).
     */
    public void applyDiscountToAll(double discountRate) {
        products.forEach(product -> product.applyDiscount(discountRate));
    }
 
    /**
     * Clears all products from the cart.
     */
    public void clear() {
        products.clear();
    }
 
    /**
     * Gets the number of products in the cart.
     * @return The count of products in the cart.
     */
    public int getProductCount() {
        return products.size();
    }
 
    /**
     * Provides a string representation of all products in the cart.
     * @return A string listing all products.
     */
    @Override
    public String toString() {
        return products.stream()
                .map(Product::toString)
                .collect(Collectors.joining(", ", "Cart{products=[", "]}"));
    }
}
