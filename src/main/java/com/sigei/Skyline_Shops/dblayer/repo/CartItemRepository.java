package com.sigei.Skyline_Shops.dblayer.repo;

import com.sigei.Skyline_Shops.dblayer.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}
