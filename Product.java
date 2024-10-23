import java.util.Objects; 
import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String name;
    private double price;
    
    /**
     * Constructor to initialize a Product object.
     * @param id Unique identifier for the product.
     * @param name Name of the product.
     * @param price Price of the product. Must be non-negative.
     */
    public Product(Long id, String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }
 
    // Getters
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public double getPrice() {
        return price;
    }
 
    // Setters with validation
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
 
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
 
    /**
     * Applies a discount to the product price.
     * @param discountRate Discount rate in percentage (0-100).
     */
    public void applyDiscount(double discountRate) {
        if (discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 100");
        }
        this.price -= this.price * (discountRate / 100);
    }
 
    /**
     * Overriding the equals method to compare two Product objects based on id, name, and price.
     * @param o Object to compare with.
     * @return true if both objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name);
    }
 
    /**
     * Overriding the hashCode method to generate a hash based on the product's fields.
     * @return Hash code for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
 
    /**
     * Overriding the toString method to provide a string representation of the Product object.
     * @return String describing the product.
     */
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + '}';
    }
}
