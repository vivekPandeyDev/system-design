package com.loop.troop.design.observer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StockMarketServiceImpl implements StockMarketService{

    private final Map<String, Stock> stockMap = new ConcurrentHashMap<>();
    private final List<StockNotifier> stockNotifiers;

    public StockMarketServiceImpl(List<StockNotifier> stockNotifiers) {
        Objects.requireNonNull(stockNotifiers,"Must be a not null notifier instance");
        this.stockNotifiers = stockNotifiers;
    }

    @Override
    public boolean addStock(String stockName, String stockSymbol, double stockPrice) {
        stockMap.putIfAbsent(stockName, new Stock(stockName, stockSymbol, stockPrice));
        boolean isStockAdded = stockMap.containsKey(stockName);
        if (isStockAdded)
            stockNotifiers.forEach(stockNotifier -> stockNotifier.notifyStockChange(stockMap.get(stockName)));
        return isStockAdded;
    }

    @Override
    public boolean updateStockPrice(String stockName, double stockPrice) {
        var stock = stockMap.computeIfPresent(stockName, (key, existingStock) -> new Stock(existingStock.stockName(),existingStock.symbol(), stockPrice));
        boolean isStockUpdated = Objects.nonNull(stock);
        if (isStockUpdated)
            stockNotifiers.forEach(stockNotifier -> stockNotifier.notifyStockChange(stockMap.get(stockName)));
        return isStockUpdated;
    }

    @Override
    public Stock getStock(String stockName) {
        return stockMap.get(stockName);
    }

    public void addNotifier(StockNotifier stockNotifier) {
        if (Objects.nonNull(stockNotifier))
            stockNotifiers.add(stockNotifier);
    }
    public void removeNotifier(StockNotifier stockNotifier) {
        if (Objects.nonNull(stockNotifier))
            stockNotifiers.remove(stockNotifier);
    }
}
