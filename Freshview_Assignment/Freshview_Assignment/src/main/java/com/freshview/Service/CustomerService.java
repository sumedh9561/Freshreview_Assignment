package com.freshview.Service;

import org.springframework.stereotype.Service;

import com.freshview.exceptions.CustomerNotFoundException;
import com.freshview.model.Customer;
@Service
public interface CustomerService {

	Customer addCustomer(Customer customer);

	String removeCustomer(Long customerId) throws CustomerNotFoundException;

	String addItemsToOrder(Long customerId, Long itemId);
}
