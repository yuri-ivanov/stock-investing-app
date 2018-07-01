package com.stockinvest.stock;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * data source for stock prices
 */
public interface StockPriceDataSource {

    /**
     * daily prices
     * @param date required date, can be today
     * @return list of deals for the day
     */
    List<StockTrade> getDayPrices(LocalDate date) throws IOException;
}
