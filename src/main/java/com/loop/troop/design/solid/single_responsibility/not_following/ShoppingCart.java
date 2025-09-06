package com.loop.troop.design.solid.single_responsibility.not_following;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Data
@Log4j2
public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if (Objects.isNull(product)){
            throw new IllegalStateException("Product should not be null in order to add in shopping cart");
        }
        products.add(product);
    }
    public void addProduct(List<Product> product){
        if (product == null) {
            throw new IllegalStateException("Product list should not be null in order to add in shopping cart");
        }

        if (product.stream().anyMatch(Objects::isNull)) {
            throw new IllegalStateException("Product list contains null elements, which are not allowed");
        }
        products.addAll(product);
    }

    public BigDecimal calculateTotal(){
        BigDecimal totalProducts = this.products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        log.debug("calculated total price for cart items : {}",totalProducts);
        return totalProducts;
    }

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
    public void saveToDb(){
        String productDetails = products.stream().map(product -> String.format("[product name : %s , product price: %s ]", product.getName(), product.getPrice())).collect(Collectors.joining(",\n"));
        log.info("\nSaving shopping cart details to db: \n{}",productDetails);
    }

    public static void main(String[] args) {
        Product product = new Product("test",BigDecimal.ONE);
        Product product2 = new Product("test2",BigDecimal.ONE);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(List.of(product,product2));
        shoppingCart.printInvoice();
        shoppingCart.saveToDb();
    }
}
