package com.sigei.Skyline_Shops.dblayer.repo;

import com.sigei.Skyline_Shops.dblayer.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);

}
