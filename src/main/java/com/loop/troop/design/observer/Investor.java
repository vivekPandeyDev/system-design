package com.loop.troop.design.observer;

import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public record Investor(String name,String email) implements StockObserver {

    @Override
    public void update(String stockName, String stockSymbol, double stockPrice) {
        var message = """
            Notification sent investor %s about stock price change for %s with symbol %s to %.2f
            """.formatted(name, stockName, stockSymbol, stockPrice);
        log.info(message);
        log.info("Investor {} sending the stock update to it's client",name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Investor investor = (Investor) o;
        return Objects.equals(name, investor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
