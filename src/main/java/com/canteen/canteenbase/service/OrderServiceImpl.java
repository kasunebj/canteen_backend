package com.canteen.canteenbase.service;

import com.canteen.canteenbase.entity.Order;
import com.canteen.canteenbase.entity.OrderItem;
import com.canteen.canteenbase.repositories.OrderItemRepository;
import com.canteen.canteenbase.repositories.OrderRepository;
import com.canteen.canteenbase.responseDTOs.OrderItemDto;
import com.canteen.canteenbase.responseDTOs.OrderRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<Order> getCompletedOrdersByUserId(Long userId) {
        return orderRepository.findCompletedOrdersByUserId(userId);
    }

        @Transactional
        @Override
        public Order createOrder(OrderRequest orderRequest,Long userId) {
            Order order = new Order();
            order.setTotalPrice(orderRequest.getTotalPrice());
            order.setOrderCompleted(false);
            order.setUser(userId);
            List<OrderItem> orderItems = orderRequest.getItems().stream()
                    .map(itemDto -> {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setItemId(itemDto.getItemId());
                        orderItem.setQuantity(itemDto.getQuantity());
                        orderItem.setOrder(order); // Ensure the order reference is set
                        return orderItem;
                    })
                    .collect(Collectors.toList());

            order.setItems(orderItems); // Set the list of order items in the order

            // Save the order which will cascade the save operation to order items
             orderRepository.save(order);
//             orderItemRepository.saveAll(orderItems);
             return order;
        }

}
