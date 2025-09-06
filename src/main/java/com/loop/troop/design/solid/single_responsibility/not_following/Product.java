package com.loop.troop.design.solid.single_responsibility.not_following;

import lombok.Data;

import lombok.extern.log4j.Log4j2;
import java.math.BigDecimal;


/**
 * The type Product.
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
