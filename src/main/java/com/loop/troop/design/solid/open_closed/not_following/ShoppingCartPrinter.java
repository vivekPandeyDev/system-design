package com.loop.troop.design.solid.open_closed.not_following;

import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

/**
 * The type Shopping cart printer.
 */
@Log4j2
public class ShoppingCartPrinter {

    /**
     * The Shopping cart.
     */
    ShoppingCart shoppingCart;

    /**
     * Instantiates a new Shopping cart printer.
     *
     * @param shoppingCart the shopping cart
     */
    public ShoppingCartPrinter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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
     * and the total price is calculated by {@link ShoppingCart#calculateTotal()}.
     */
    public void printInvoice(){
        String productLines = shoppingCart.getProducts().stream()
                .map(p -> String.format("Product name : %s , Product price : %s",
                        p.getName(), p.getPrice()))
                .collect(Collectors.joining("\n"));

        String invoice = String.format("""
        Shopping cart Invoice:
        %s
        Total: $%s
        """, productLines, shoppingCart.calculateTotal());

        log.info(invoice);
    }
}
