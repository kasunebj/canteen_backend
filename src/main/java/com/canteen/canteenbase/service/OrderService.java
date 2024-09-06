package com.canteen.canteenbase.service;

import com.canteen.canteenbase.entity.Order;
import com.canteen.canteenbase.responseDTOs.OrderItemDto;
import com.canteen.canteenbase.responseDTOs.OrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest,Long userId);
    List<Order> getCompletedOrdersByUserId(Long userId);
    List<Order> getOngoingOrdersByUserId(Long userId);

}
