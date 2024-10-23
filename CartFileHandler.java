import java.io.*;
import java.nio.file.Files; // For advanced file handling
import java.nio.file.Paths; // For checking if the file exists
import java.nio.charset.StandardCharsets; // For standard charset when writing logs or text files
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
 
public class CartFileHandler {
 
    /**
     * Saves the cart's products to a file using serialization.
     *
     * @param cart the Cart object containing the products
     * @param filename the name of the file where the cart will be saved
     * @throws IOException if an I/O error occurs during file writing
     */
    public static void saveCart(Cart cart, String filename) throws IOException {
        // Check if cart is null
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
 
        // Write cart products to file using ObjectOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cart.getProducts());
        }
    }
 
    /**
     * Loads the cart's products from a file using deserialization.
     *
     * @param filename the name of the file from which the cart will be loaded
     * @return the list of products deserialized from the file
     * @throws IOException if an I/O error occurs during file reading
     * @throws ClassNotFoundException if the class of the serialized object cannot be found
     */
    public static List<Product> loadCart(String filename) throws IOException, ClassNotFoundException {
        // Check if file exists before attempting to load
        if (!Files.exists(Paths.get(filename))) {
            throw new FileNotFoundException("The file " + filename + " does not exist.");
        }
 
        // Read cart products from file using ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Product>) ois.readObject();
        }
    }
 
    /**
     * Deletes the cart file if it exists.
     *
     * @param filename the name of the file to delete
     * @return true if the file was successfully deleted, false otherwise
     * @throws IOException if an I/O error occurs during file deletion
     */
    public static boolean deleteCartFile(String filename) throws IOException {
        if (Files.exists(Paths.get(filename))) {
            return Files.deleteIfExists(Paths.get(filename));
        }
        return false; // File did not exist
    }
 
    /**
     * Appends a custom log message to a text file for tracking cart operations.
     * The log file will be created if it doesn't exist.
     *
     * @param logMessage the message to append to the log file
     * @param logFilename the name of the log file
     * @throws IOException if an I/O error occurs during file writing
     */
    public static void logCartOperation(String logMessage, String logFilename) throws IOException {
        // Append log message to file
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(logFilename), StandardCharsets.UTF_8, 
                                                             java.nio.file.StandardOpenOption.CREATE, 
                                                             java.nio.file.StandardOpenOption.APPEND)) {
            writer.write(LocalDateTime.now() + ": " + logMessage);
            writer.newLine();
        }
    }
 
    /**
     * Loads an empty cart if the specified file doesn't exist, allowing for default cart initialization.
     *
     * @param filename the name of the file from which the cart will be loaded
     * @return a list of products, empty if file doesn't exist
     * @throws IOException if an I/O error occurs during file reading
     * @throws ClassNotFoundException if the class of the serialized object cannot be found
     */
    public static List<Product> loadOrCreateEmptyCart(String filename) throws IOException, ClassNotFoundException {
        if (!Files.exists(Paths.get(filename))) {
            return new ArrayList<>(); // Return an empty list if file does not exist
        }
        return loadCart(filename); // Load cart if file exists
    }
 
    /**
     * Retrieves the size of the cart file in bytes.
     *
     * @param filename the name of the file whose size is to be checked
     * @return the size of the file in bytes, or -1 if the file does not exist
     * @throws IOException if an I/O error occurs
     */
    public static long getCartFileSize(String filename) throws IOException {
        if (Files.exists(Paths.get(filename))) {
            return Files.size(Paths.get(filename));
        }
        return -1; // File does not exist
    }
}
