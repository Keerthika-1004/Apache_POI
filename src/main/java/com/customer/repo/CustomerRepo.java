package com.customer.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByCustomerOrderId(String customerOrderId);

	Customer findByCustomerId(int customerId);

}
