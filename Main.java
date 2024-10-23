import java.io.IOException;
import java.nio.file.Files; // For advanced file handling
import java.nio.file.Paths; // For file path checks
import java.util.List;
 
public class Main {
 
    /**
     * The main entry point of the application.
     * This method simulates the process of adding products to a cart, applying a discount, saving the cart to a file,
     * and loading it back.
     *
     * @param args command-line arguments
     */
    public static void main() {
        CartService cartService = new CartService();
 
        // Add products to the cart
        cartService.addProduct(new Product(1L, "Laptop", 1200.00));
        cartService.addProduct(new Product(2L, "Headphones", 150.00));
        cartService.addProduct(new Product(3L, "Mouse", 50.00));
 
        // Display the cart contents
        System.out.println("Cart Contents:");
        cartService.displayCart();
 
        // Calculate total price with a discount strategy
        DiscountStrategy discountStrategy = new PercentageDiscount(10); // 10% discount
        double total = cartService.calculateTotal();
        System.out.println("Total before discount: " + total);
        System.out.println("Total after discount: " + discountStrategy.applyDiscount(total));
 
        // Save the cart to a file
        String filename = "cart.dat";
        saveCartToFile(cartService, filename);
 
        // Load the cart from the file
        loadCartFromFile(filename);
    }
 
    /**
     * Saves the current cart to a specified file.
     * This method encapsulates the cart saving logic with proper exception handling.
     *
     * @param cartService the cart service containing the cart to be saved
     * @param filename the name of the file where the cart will be saved
     */
    private static void saveCartToFile(CartService cartService, String filename) {
        try {
            CartFileHandler.saveCart(cartService.getCart(), filename);
            System.out.println("Cart saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving cart to file: " + e.getMessage());
            logError(e, "Error saving cart to file: " + filename);
        }
    }
 
    /**
     * Loads the cart from a specified file and displays its contents.
     * This method handles loading and printing the cart, including error management.
     *
     * @param filename the name of the file from which the cart will be loaded
     */
    private static void loadCartFromFile(String filename) {
        if (!Files.exists(Paths.get(filename))) {
            System.err.println("Cart file does not exist: " + filename);
            return;
        }
 
        try {
            List<Product> loadedCart = CartFileHandler.loadCart(filename);
            System.out.println("Cart loaded from file:");
            loadedCart.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading cart from file: " + e.getMessage());
            logError(e, "Error loading cart from file: " + filename);
        }
    }
 
    /**
     * Logs an error message to a log file for future reference.
     * This method helps to keep a log of any file-handling issues.
     *
     * @param e the exception that was caught
     * @param message a custom error message to be logged
     */
    private static void logError(Exception e, String message) {
        try {
            CartFileHandler.logCartOperation(message + " - " + e.getMessage(), "cart_error.log");
            System.out.println("Error logged: " + message);
        } catch (IOException ioException) {
            System.err.println("Error writing to log file: " + ioException.getMessage());
        }
    }
}
