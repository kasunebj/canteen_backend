package com.canteen.canteenbase.repositories;

import com.canteen.canteenbase.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ItemRepository extends JpaRepository<Item, Long> {
       // List<Item> findByAvailability(boolean availability);
    }


