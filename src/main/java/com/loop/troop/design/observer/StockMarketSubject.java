package com.loop.troop.design.observer;



import java.util.Set;

/**
 * The interface Stock market.
 * Subject interface for observer design
 */
public interface StockMarketSubject {
    boolean addObserver(StockObserver observer);
    boolean removeObserver(StockObserver observer);
    void notifyObserver(String stockName,String stockSymbol,double stockPrice);
    Set<StockObserver> getAllObserver();
}
