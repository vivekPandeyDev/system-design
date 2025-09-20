package com.loop.troop.design.observer;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class Runner {


    public static final String STOCK_NAME = "Apple";

    public static void main(String[] args) {
        StockMarketObserverManager stockMarketObserverManager = new StockMarketObserverManager();
        StockNotifier logNotifier = new StockMakerSubjectNotifier(stockMarketObserverManager);
        StockNotifier emailNotifier =  new EmailNotifier(stockMarketObserverManager);
        StockMarketService stockService = new StockMarketServiceImpl(List.of(logNotifier,emailNotifier));
        // Add observers
        stockMarketObserverManager.addObserver(new Investor("Alice","alice123@gmail.com"));
        stockMarketObserverManager.addObserver(new Investor("Bob","bob123@gmail.com"));
        // Add stock
        boolean addedStock = stockService.addStock(STOCK_NAME, "AAPL", 150);
        log.info("Is new Stock added : {}",addedStock);
        // Update stock
        boolean stockPriceUpdated = stockService.updateStockPrice(STOCK_NAME, 155);
        log.info("Is stock price updated for: {} -> {}",STOCK_NAME,stockPriceUpdated);
    }
}
