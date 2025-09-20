package com.loop.troop.design.observer;

/**
 * The interface Stock observer.
 * stock market observer that tells it's implementation about the stock market changes
 */
public interface StockObserver {
    void update(String stockName,String stockSymbol,double stockPrice);
}
