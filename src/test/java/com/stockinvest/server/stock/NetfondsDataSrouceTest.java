package com.stockinvest.server.stock;

import com.stockinvest.stock.NetfondsDataSource;
import com.stockinvest.stock.OrderType;
import com.stockinvest.stock.StockTrade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class NetfondsDataSrouceTest {
    NetfondsDataSource netfondsData;

    @Before
    public void setup(){
        netfondsData = new NetfondsDataSource(NetfondsDataSrouceTest.class.getClassLoader().getResource("nas-20180627.csv").toString());
    }

    @Test
    public void testDayPrices() throws IOException {
        List<StockTrade> prices = netfondsData.getDayPrices(LocalDate.of(2018, 6, 27));
        Assert.assertNotNull(prices);
        StockTrade price = prices.get(11);
        assertEquals(OrderType.SELL, price.getType());
        assertEquals(39, price.getQuantity());
    }
}
