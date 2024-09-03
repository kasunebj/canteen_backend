package com.canteen.canteenbase.repositories;

import com.canteen.canteenbase.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
