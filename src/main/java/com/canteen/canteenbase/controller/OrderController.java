package com.canteen.canteenbase.controller;

import com.canteen.canteenbase.entity.Order;
import com.canteen.canteenbase.responseDTOs.OrderRequest;
import com.canteen.canteenbase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createProduct(@RequestBody OrderRequest orderRequest,@RequestHeader("userId") Long userId) {
        Order order = orderService.createOrder(orderRequest,userId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Order>> getCompletedOrders(
            @RequestHeader("userId") Long userId) {

        // Fetch completed orders for the user
        List<Order> completedOrders = orderService.getCompletedOrdersByUserId(userId);

        if (completedOrders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(completedOrders);
        }
    }

    @GetMapping("/ongoing")
    public ResponseEntity<List<Order>> getOngoingOrders(
            @RequestHeader("userId") Long userId) {

        // Fetch completed orders for the user
        List<Order> completedOrders = orderService.getOngoingOrdersByUserId(userId);

        if (completedOrders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(completedOrders);
        }
    }
}

