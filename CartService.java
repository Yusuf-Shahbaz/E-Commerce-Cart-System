import java.util.Comparator;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

 
/**
 * Service class to manage the operations on a shopping cart.
 */
public class CartService {
    private Cart cart = new Cart();
 
    /**
     * Adds a product to the cart and prints a confirmation.
     * 
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        cart.addProduct(product);
        System.out.println("Added product: " + product.getName());
    }
    
    
    
    public Cart getCart(){
        return cart;
    }
    
    /**
     * Removes a product from the cart by its ID if found.
     * 
     * @param id The ID of the product to remove.
     */
    public void removeProductById(Long id) {
        Optional<Product> product = cart.getProducts().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        product.ifPresent(cart::removeProduct);
    }
    
    
 
    /**
     * Displays the products in the cart by printing each product's details.
     */
    public void displayCart() {
        List<Product> products = cart.getProducts();
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            products.forEach(System.out::println);
        }
    }
 
    /**
     * Calculates the total cost of all products in the cart.
     * 
     * @return The total price of products in the cart.
     */
    public double calculateTotal() {
        return cart.calculateTotal();
    }
 
    /**
     * Retrieves the most expensive product in the cart.
     * 
     * @return The most expensive product, or null if the cart is empty.
     */
    public Product getMostExpensiveProduct() {
        return cart.getProducts().stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }
 
    /**
     * Finds the least expensive product in the cart.
     * 
     * @return The least expensive product, or null if the cart is empty.
     */
    public Product getCheapestProduct() {
        return cart.getProducts().stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }
    
    
    /**
     * Clears all products from the cart.
     */
    public void clearCart() {
        cart.clear();
        System.out.println("The cart has been cleared.");
    }
 
    /**
     * Finds all products in the cart that are below a certain price.
     * 
     * @param price The threshold price.
     * @return List of products priced below the given amount.
     */
    public List<Product> findProductsBelowPrice(double price) {
        return cart.getProducts().stream()
                .filter(p -> p.getPrice() < price)
                .collect(Collectors.toList());
    }
 
    /**
     * Counts the total number of products in the cart.
     * 
     * @return The number of products in the cart.
     */
    public int getTotalProductCount() {
        return cart.getProducts().size();
    }
}
