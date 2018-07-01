package com.stockinvest.stock;

import com.stockinvest.server.GreetingsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {
    private static final Logger log = LoggerFactory.getLogger(GreetingsListener.class);

    @Autowired
    private StockPriceDataSource stockPriceDataSource;

    public List<StockTrade> getPrices(String ticker, LocalDate date) {
        try{
            return stockPriceDataSource.getDayPrices(date);
        } catch(IOException e){
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
