package com.loop.troop.design.solid.single_responsibility.following;

import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

@Log4j2
public class ShoppingCartPrinter {

    ShoppingCart shoppingCart;

    public ShoppingCartPrinter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

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
