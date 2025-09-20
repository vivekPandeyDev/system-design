package com.loop.troop.design.observer;

import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Log4j2
public class StockMarketObserverManager implements StockMarketSubject {

    private final Set<StockObserver> stockObservers = new CopyOnWriteArraySet<>();
    @Override
    public boolean addObserver(StockObserver observer) {
        return stockObservers.add(observer);
    }

    @Override
    public boolean removeObserver(StockObserver observer) {
        return stockObservers.remove(observer);
    }

    @Override
    public Set<StockObserver> getAllObserver() {
        return stockObservers;
    }

    @Override
    public void notifyObserver(String stockName, String stockSymbol, double stockPrice) {
        stockObservers.forEach(observer -> observer.update(stockName,stockSymbol,stockPrice));
    }
}
