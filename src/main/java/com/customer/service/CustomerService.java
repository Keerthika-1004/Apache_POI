package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.CustomerAlreadyExitsException;
import com.customer.exception.CustomerOrderIdAlreadyExistsException;
import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo repo;

	public String insertCustomer(Customer customer) {
//		
		Customer cus = repo.findByCustomerOrderId(customer.getCustomerOrderId());
		Customer cus1 = repo.findByCustomerId(customer.getCustomerId());

		if (cus != null) {
			throw new CustomerOrderIdAlreadyExistsException("Customer order Id exists");
		} else if (cus1 != null) {
			throw new CustomerAlreadyExitsException("Customer Already Exists");
		}
		try {
			repo.save(customer);
			return "customer Id created successfully";
		} catch (Exception e) {
			return e.getMessage();

		}

	}

}
