package com.stockinvest.server;

import com.stockinvest.stock.OrderType;
import com.stockinvest.stock.StockTrade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GreetingsController {
    private final TradeVolumeAnalyticService tradeVolumeAnalyticService;
    public GreetingsController(TradeVolumeAnalyticService tradeVolumeAnalyticService) {
        this.tradeVolumeAnalyticService = tradeVolumeAnalyticService;
    }

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        BigVolumeMessage greetings = new BigVolumeMessage(new StockTrade(System.currentTimeMillis(), 0, 1, OrderType.SELL), System.currentTimeMillis());
        tradeVolumeAnalyticService.sendGreeting(greetings);
    }
}
