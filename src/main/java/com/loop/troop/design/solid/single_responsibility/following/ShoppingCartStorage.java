package com.loop.troop.design.solid.single_responsibility.following;

import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;

@Log4j2
public class ShoppingCartStorage {

    ShoppingCart shoppingCart;

    public ShoppingCartStorage(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void saveToDb(){
        String productDetails = shoppingCart.getProducts().stream().map(product -> String.format("[product name : %s , product price: %s ]", product.getName(), product.getPrice())).collect(Collectors.joining(",\n"));
        log.info("\nSaving shopping cart details to db: \n{}",productDetails);
    }
}
