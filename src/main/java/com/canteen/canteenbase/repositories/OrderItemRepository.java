package com.canteen.canteenbase.repositories;

import com.canteen.canteenbase.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}