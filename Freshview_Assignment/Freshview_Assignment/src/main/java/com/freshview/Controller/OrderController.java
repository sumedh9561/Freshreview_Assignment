package com.freshview.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freshview.Service.OrderService;
import com.freshview.model.Order;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/{orderId}/discounts")
    public ResponseEntity<Order> calculateDiscounts(@PathVariable Long orderId, @RequestParam Long customerId) {
        Order order = orderService.findById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        order = orderService.calculateDiscounts(order, customerId);
        return ResponseEntity.ok(order);
    }
}
