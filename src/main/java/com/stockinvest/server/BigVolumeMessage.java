package com.stockinvest.server;


import com.stockinvest.stock.StockTrade;

public class BigVolumeMessage {
    private long timestamp;
    private StockTrade trade;

    public BigVolumeMessage() {
    }

    public BigVolumeMessage(StockTrade trade, long timestamp) {
        this.timestamp = timestamp;
        this.trade= trade;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public StockTrade getMessage() {
        return trade;
    }

    public void setMessage(StockTrade trade) {
        this.trade = trade;
    }
}