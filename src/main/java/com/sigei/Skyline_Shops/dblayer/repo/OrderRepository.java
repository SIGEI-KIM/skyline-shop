package com.sigei.Skyline_Shops.dblayer.repo;

import com.sigei.Skyline_Shops.dblayer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
