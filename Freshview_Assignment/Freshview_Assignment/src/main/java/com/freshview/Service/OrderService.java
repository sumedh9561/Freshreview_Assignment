package com.freshview.Service;

import org.springframework.stereotype.Service;

import com.freshview.model.Order;

@Service
public interface OrderService {
	
    Order calculateDiscounts(Order order, Long customerId);

	Order findById(Long orderId);

}
