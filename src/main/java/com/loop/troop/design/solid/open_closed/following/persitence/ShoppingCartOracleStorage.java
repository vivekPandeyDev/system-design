package com.loop.troop.design.solid.open_closed.following.persitence;

import com.loop.troop.design.solid.open_closed.following.ShoppingCart;
import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

/**
 * The type Shopping cart storage.
 */
@Log4j2
public class ShoppingCartOracleStorage implements PersistenceStorage {

    /**
     * The Shopping cart.
     */
    ShoppingCart shoppingCart;

    /**
     * Instantiates a new Shopping cart storage.
     *
     * @param shoppingCart the shopping cart
     */
    public ShoppingCartOracleStorage(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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
        String productDetails = shoppingCart.getProducts().stream().map(product -> String.format("[product name : %s , product price: %s ]", product.getName(), product.getPrice())).collect(Collectors.joining(",\n"));
        log.info("\nSaving shopping cart details to oracle db: \n{}",productDetails);
    }
}
