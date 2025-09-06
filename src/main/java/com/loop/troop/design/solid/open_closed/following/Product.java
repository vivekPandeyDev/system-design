package com.loop.troop.design.solid.open_closed.following;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;


/**
 * Represents a product with a name and price.
 * <p>
 * Instances of this class are immutable in terms of public API if you choose not to provide setters.
 */
@Data
@Log4j2
public class Product{
    private String name;
    private BigDecimal price;


    /**
     * Instantiates a new Product.
     *
     * @param name  the name
     * @param price the price
     */
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}
