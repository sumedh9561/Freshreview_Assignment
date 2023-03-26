package com.freshview.ServiceImpl;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshview.Repository.OrderRepository;
import com.freshview.Service.OrderService;
import com.freshview.exceptions.OrderNotFoundException;
import com.freshview.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order calculateDiscounts(Order order, Long customerId) {

        List<Order> orderHistory = orderRepo.findByCustomerId(customerId);

        int numOrders = orderHistory.size();

        double discountRate = 0.0;
        if (numOrders > 10 && numOrders <= 20) {
            discountRate = 0.1;
        } else if (numOrders > 20) {
            discountRate = 0.2;
        }

        boolean isBFMCDiscEligible = //logic to check eligibility for BFCM discount
        if (isBFMCDiscEligible) {
            discountRate += 0.15;
        }

        for (OrderItem item : order.getItems()) {
            double itemPrice = item.getPrice();
            int quantity = item.getQuantity();
            double itemDiscount = itemPrice * discountRate;
            double totalItemPrice = (itemPrice - itemDiscount) * quantity;
            item.setPrice(totalItemPrice);
        }

        double totalDiscount = order.getItems().stream()
                                .mapToDouble(item -> item.getPrice() * discountRate)
                                .sum();

        double totalPrice = order.getTotalPrice();
        double finalPrice = totalPrice - totalDiscount;
        order.setTotalPrice(finalPrice);

        return orderRepo.save(order);
    }

    @Override
    public Order findById(Long orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        }
    }
}
