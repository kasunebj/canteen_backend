package com.canteen.canteenbase.service;

import com.canteen.canteenbase.entity.Order;
import com.canteen.canteenbase.entity.OrderItem;
import com.canteen.canteenbase.repositories.OrderItemRepository;
import com.canteen.canteenbase.repositories.OrderRepository;
import com.canteen.canteenbase.responseDTOs.OrderItemDto;
import com.canteen.canteenbase.responseDTOs.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        List<OrderItemDto> items = orderRequest.getItems();
        order.setTotalPrice(orderRequest.getTotalPrice());
        for (OrderItemDto itemDto : items) {
            OrderItem item = new OrderItem();
            item.setItemId(itemDto.getItemId());
            item.setQuantity(itemDto.getQuantity());
            item.setOrder(order);
            order.getItems().add(item);
        }
        return orderRepository.save(order);
    }


}
