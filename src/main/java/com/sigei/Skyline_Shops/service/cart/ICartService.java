package com.sigei.Skyline_Shops.service.cart;

import com.sigei.Skyline_Shops.dblayer.entity.Cart;
import com.sigei.Skyline_Shops.dblayer.entity.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
