package com.loop.troop.design.solid.single_responsibility.not_following;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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
     * Generates and logs a shopping cart invoice.
     * <p>
     * This method prints the invoice in the following format:
     * <pre>
     * Shopping cart Invoice:
     * Product name : &lt;name&gt; , Product price : &lt;price&gt;
     * Product name : &lt;name&gt; , Product price : &lt;price&gt;
     * ...
     * Total: $&lt;total&gt;
     * </pre>
     * Each product line is generated from the products in the shopping cart,
     * and the total price is calculated by {@link com.loop.troop.design.solid.single_responsibility.following.ShoppingCart#calculateTotal()}.
     */
    public void printInvoice(){
        String productLines = products.stream()
                .map(p -> String.format("Product name : %s , Product price : %s",
                        p.getName(), p.getPrice()))
                .collect(Collectors.joining("\n"));

        String invoice = String.format("""
        Shopping cart Invoice:
        %s
        Total: $%s
        """, productLines, calculateTotal());

        log.info(invoice);
    }

    /**
     * Prepares and logs the shopping cart details for saving to the database.
     * <p>
     * Each product is formatted as:
     * <pre>
     * [product name : &lt;name&gt; , product price : &lt;price&gt; ]
     * </pre>
     * Multiple products are separated by commas and line breaks.
     * <p>
     * The actual database saving logic should replace this logging call in a real implementation.
     */
    public void saveToDb(){
        String productDetails = products.stream().map(product -> String.format("[product name : %s , product price: %s ]", product.getName(), product.getPrice())).collect(Collectors.joining(",\n"));
        log.info("\nSaving shopping cart details to db: \n{}",productDetails);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Product product = new Product("test",BigDecimal.ONE);
        Product product2 = new Product("test2",BigDecimal.ONE);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(List.of(product,product2));
        shoppingCart.printInvoice();
        shoppingCart.saveToDb();
    }
}
