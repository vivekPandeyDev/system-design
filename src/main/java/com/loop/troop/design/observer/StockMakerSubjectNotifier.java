package com.loop.troop.design.observer;


import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public class StockMakerSubjectNotifier implements StockNotifier{
    private StockMarketSubject stockMarketSubject;

    public StockMakerSubjectNotifier(StockMarketSubject stockMarketSubject) {
        Objects.requireNonNull(stockMarketSubject,"Must be a not null stock market subject instance");
        this.stockMarketSubject = stockMarketSubject;
    }

    @Override
    public void notifyStockChange(Stock stock) {
        log.info("Notify all the observers about the stock change for stock name: {}",stock.stockName());
        stockMarketSubject.notifyObserver(stock.stockName(),stock.symbol(),stock.price());
    }

    public void setStockMarketSubject(StockMarketSubject stockMarketSubject) {
        if (Objects.nonNull(stockMarketSubject))
            this.stockMarketSubject = stockMarketSubject;
    }
}
