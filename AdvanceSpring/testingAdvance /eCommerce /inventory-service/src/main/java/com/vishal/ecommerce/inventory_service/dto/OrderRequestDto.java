package com.vishal.ecommerce.inventory_service.dto;

import com.vishal.ecommerce.order_service.dto.OrderRequestItemDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private List<OrderRequestItemDto> items;
}

