------------------------------------------------------------------------
 E-Commerce Cart System
------------------------------------------------------------------------
 
  Overview
This is an   E-commerce Cart System   developed in   Java   using   BlueJ  , implementing a flexible shopping cart with various discount strategies. The system allows users to add products to the cart, apply discounts, and manage the cart’s contents efficiently.
 
   Features
-   Product Management  : Add products to the cart with details like product ID, name, and price.
-   Cart Operations  : Add, view, and remove products from the shopping cart.
-   Discount Strategy  : Apply different discount types (flat rate, percentage) to the total price.
-   File Handling  : Store and retrieve cart data using file operations.
-   Custom Exceptions  : Manage error handling through custom exceptions.
 
   Class Structure
 
    1.   Product  
   - Represents the individual products available for purchase.
   - Attributes:
     -  int productID 
     -  String productName 
     -  double productPrice 
 
    2.   Cart  
   - Manages the products added to the cart.
   - Responsible for calculating the total and applying discounts.
 
    3.   CartService  
   - Handles the overall logic for managing the cart and interacting with different components (like the discount strategies).
   - Coordinates operations like adding products, removing products, and calculating total price with discounts.
 
    4.   DiscountStrategy (Interface)  
   - Defines the strategy pattern for applying different types of discounts.
   - Methods:
     -  double applyDiscount(double total) 
 
    5.   FlatDiscount  
   - Implements  DiscountStrategy  to provide a flat discount on the cart's total.
   - Example: A $10 discount on the total amount.
 
    6.   PercentageDiscount  
   - Implements  DiscountStrategy  to provide a percentage-based discount on the total.
   - Example: 10% off the total amount.
 
    7.   CartFileHandler  
   - Responsible for saving the cart’s contents to a file and loading it back into the system.
 
    8.   CartException  
   - Custom exception class to handle errors related to cart operations (e.g., removing a product that isn’t in the cart).
 
    9.   Main  
   - The entry point of the application, providing a command-line interface for users to interact with the cart system.
 
   Setup and Installation
 
1.   Requirements  :
   - Java Development Kit (JDK) 8 or higher
   - BlueJ IDE
 
2.   Project Structure  :
   -   Product.java  : Handles product-related information.
   -   Cart.java  : Manages the cart and its operations.
   -   CartService.java  : The service layer for interacting with cart functions.
   -   DiscountStrategy.java  : Interface for discount logic.
   -   FlatDiscount.java   and   PercentageDiscount.java  : Implementations of discount strategies.
   -   CartFileHandler.java  : Handles file operations.
   -   CartException.java  : Custom exception handling.
   -   Main.java  : The entry point for running the program.
 
3.   Steps to Run the Project  :
   - Download and install   BlueJ   from [https://www.bluej.org/](https://www.bluej.org/).
   - Open BlueJ and   import the project folder   containing the  .java  files.
   - Open  Main.java  in BlueJ, and   right-click   to select the  void main(String[] args)  method to run the project.
 
   How to Use the System
 
1.   Starting the Application  :
   - When you run  Main.java , the system will display available products.
 
2.   Add Products to Cart  :
   - Enter the   product ID   to add items to the cart.
 
3.   View Cart  :
   - Enter the corresponding command to   view the cart contents  .
 
4.   Apply Discounts  :
   - Choose either the   FlatDiscount   or   PercentageDiscount   strategy to apply discounts to the cart's total.
 
5.   Remove Products  :
   - Enter the   product ID   to remove items from the cart.
 
6.   Save Cart  :
   - The cart contents can be saved to a file for future retrieval.
 
7.   Load Cart  :
   - Load a previously saved cart using the file handler.
 
8.   Checkout  :
   - The system will calculate the total cost after applying the selected discount strategy.
 
   Future Enhancements
-   User Authentication  : Add functionality for users to sign in and manage their own carts.
-   Payment Gateway  : Integrate payment processing at checkout.
-   Database Integration  : Store product and cart data in a database.
 

