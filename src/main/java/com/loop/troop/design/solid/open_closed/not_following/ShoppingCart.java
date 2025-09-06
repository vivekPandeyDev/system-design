package com.loop.troop.design.solid.open_closed.not_following;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Shopping cart.
 */
@Data
@Log4j2
public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    /**
     * Adds a single product to the shopping cart.
     *
     * @param product the product to add; must not be null
     * @throws IllegalStateException if the product is null
     */
    public void addProduct(Product product){
        if (Objects.isNull(product)){
            throw new IllegalStateException("Product should not be null in order to add in shopping cart");
        }
        products.add(product);
    }

    /**
     * Adds a single product to the shopping cart.
     *
     * @param product the product to add; must not be null
     * @throws IllegalStateException if the product is null
     */
    public void addProduct(List<Product> product){
        if (product == null) {
            throw new IllegalStateException("Product list should not be null in order to add in shopping cart");
        }

        if (product.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("Product list contains null elements, which are not allowed");
        }
        products.addAll(product);
    }

    /**
     * Retrieves all products in the cart that match the given name.
     *
     * @param productName the name of the product to search for
     * @return a list of products with the matching name; may be empty if no products match
     */
    public List<Product> getProductByName(String productName) {
        return this.products.stream()
                .filter(p -> p.getName().equals(productName))
                .toList();
    }

    /**
     * Calculates the total price of all products in the cart.
     *
     * @return the total price as a {@link BigDecimal}
     */
    public BigDecimal calculateTotal(){
        BigDecimal totalProducts = this.products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        log.debug("calculated total price for cart items : {}",totalProducts);
        return totalProducts;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Product product = new Product("Mouse",BigDecimal.ONE);
        Product product2 = new Product("Keyboard",BigDecimal.TEN);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(List.of(product,product2));
        ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter(shoppingCart);

        // every time new requirement we need to update ShoppingCartStorage class
        ShoppingCartStorage shoppingCartStorage = new ShoppingCartStorage(shoppingCart);
        shoppingCartPrinter.printInvoice();
        shoppingCartStorage.saveToOracleDb();
        shoppingCartStorage.saveToMongoDb();
    }
}
