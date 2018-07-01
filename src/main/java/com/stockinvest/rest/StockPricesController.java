package com.stockinvest.rest;

import com.stockinvest.stock.StockTrade;
import com.stockinvest.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockPricesController {
    @Autowired
    private StockService stockService;

    @GetMapping("/{ticker}/day-trades")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<StockTrade> prices(@PathVariable("ticker") String ticker) {
        //@RequestParam(value="date", defaultValue="") String date
        return stockService.getPrices(ticker, LocalDate.now());
    }

}
