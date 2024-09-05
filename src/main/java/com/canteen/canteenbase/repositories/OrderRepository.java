package com.canteen.canteenbase.repositories;

import com.canteen.canteenbase.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query to find orders that are completed and belong to a specific user
    @Query("SELECT o FROM Order o WHERE o.orderCompleted = true AND o.user = :userId")
    List<Order> findCompletedOrdersByUserId(@Param("userId") Long userId);
}
