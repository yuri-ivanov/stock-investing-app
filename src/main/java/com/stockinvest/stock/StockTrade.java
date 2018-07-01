package com.stockinvest.stock;

import java.time.LocalDateTime;

public class StockTrade {
    private LocalDateTime time;
    private float price;
    private int quantity;
    private OrderType type;

    public StockTrade(LocalDateTime time, float price, int quantity, OrderType type) {
        this.time = time;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "StockTrade{" +
                "time=" + time +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type=" + type +
                '}';
    }
}
