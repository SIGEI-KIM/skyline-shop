package com.sigei.Skyline_Shops.service.order;

import com.sigei.Skyline_Shops.dblayer.entity.Order;
import com.sigei.Skyline_Shops.dto.OrderDto;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
