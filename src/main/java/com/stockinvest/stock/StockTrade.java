package com.stockinvest.stock;

public class StockTrade {
    private long time;
    private float price;
    private int quantity;
    private OrderType type;

    public StockTrade() {
    }

    public StockTrade(long time, float price, int quantity, OrderType type) {
        this.time = time;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public long getTime() {
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

    public void setTime(long time) {
        this.time = time;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(OrderType type) {
        this.type = type;
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
