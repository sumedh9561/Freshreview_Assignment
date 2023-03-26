package com.freshview.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freshview.Service.CustomerService;
import com.freshview.exceptions.CustomerNotFoundException;
import com.freshview.model.Customer;

@RestController
public class UserController {

	
	@Autowired
	private CustomerService customerService;
	
	

	 @PostMapping("/User")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.addCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }
	    
	    @DeleteMapping("/{customerId}")
	    public ResponseEntity<String> removeCustomer(@PathVariable Long customerId) {
	        try {
	            String message = customerService.removeCustomer(customerId);
	            return ResponseEntity.ok(message);
	        } catch (CustomerNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	
	
	
	
	
	

}
