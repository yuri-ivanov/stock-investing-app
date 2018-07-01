package com.stockinvest.stock;

import com.stockinvest.util.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NetfondsDataSource implements StockPriceDataSource {
    private final String netfondsDailyUrl;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
    private DateTimeFormatter priceDateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");

    public NetfondsDataSource() {
        netfondsDailyUrl = "https://www.netfonds.no/quotes/tradedump.php?date=%s&paper=NAS.OSE&csv_format=csv";
    }

    public NetfondsDataSource(String url) {
        try {
            netfondsDailyUrl = url;
            new URL(netfondsDailyUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StockTrade> getDayPrices(LocalDate date) throws IOException {
        List<String> csvData = IOUtils.getUrlData(new URL(String.format(netfondsDailyUrl, dateFormat.format(date))) );
        List<StockTrade> prices = new ArrayList<>();
        csvData.forEach(line -> {
            if(line.length()>6 && !line.contains("time")){
                prices.add(readStockPrice(line));
            }
        });
        return prices;
    }

    public StockTrade readStockPrice(String csvData){
        String[] items = csvData.split(",");
        return new StockTrade(LocalDateTime.parse(get(items,0), priceDateTimeFormat), Float.parseFloat(get(items,1)), Integer.parseInt(get(items,2)), parseOrderType(get(items,6)));
    }

    <T> T get(T[] items, int i){
        if(i<items.length){
            return items[i];
        }
        return null;
    }

    public OrderType parseOrderType(String type){
        if(type == null || type.isEmpty()){
            return OrderType.NONE;
        } else if("B".equalsIgnoreCase(type)){
            return OrderType.BUY;
        } else if("S".equalsIgnoreCase(type)){
            return OrderType.SELL;
        }
        return OrderType.NONE;
    }

}
