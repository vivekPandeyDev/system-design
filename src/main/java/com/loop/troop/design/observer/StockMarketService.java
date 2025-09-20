package com.loop.troop.design.observer;

public interface StockMarketService {
    boolean addStock(String stockName, String stockSymbol, double stockPrice);
    boolean updateStockPrice(String stockName, double stockPrice);
    Stock getStock(String stockName);
}
