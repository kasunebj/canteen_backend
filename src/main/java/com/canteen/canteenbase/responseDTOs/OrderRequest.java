package com.canteen.canteenbase.responseDTOs;

import java.util.List;

public class OrderRequest {
   private List<OrderItemDto> items;
   private double totalPrice;

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
