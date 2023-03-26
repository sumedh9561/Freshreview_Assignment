package com.freshview.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.freshview.Repository.CustomerRepository;
import com.freshview.Service.CustomerService;
import com.freshview.exceptions.CustomerNotFoundException;
import com.freshview.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setNumberOfOrders(0);
		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer;
	}

	@Override
	public String removeCustomer(Long customerId) throws CustomerNotFoundException {

		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found With Customer Id :" + customerId));

		customerRepo.delete(customer);
		return "Customer Sucesfully Deleted With Customer Id :" + customerId;

	}

	@Override
	public String addItemsToOrder(Long customerId, Long itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
