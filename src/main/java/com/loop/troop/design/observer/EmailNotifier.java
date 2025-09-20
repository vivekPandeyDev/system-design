package com.loop.troop.design.observer;

import lombok.extern.log4j.Log4j2;


import java.util.Objects;

@Log4j2
public class EmailNotifier implements StockNotifier {
    private final StockMarketObserverManager manager;

    public EmailNotifier(StockMarketObserverManager manager) {
        Objects.requireNonNull(manager,"stock observer manager must not be null");
        this.manager = manager;
    }


    private void sendEmail(String email, Stock stock) {
        log.info("Sending EMAIL to {} for stock {}",email,stock.stockName());
    }

    @Override
    public void notifyStockChange(Stock stock) {
        for (StockObserver observer : manager.getAllObserver()) {
            if (observer instanceof Investor inv) {
                sendEmail(inv.email(), stock);
            }
        }
    }
}
