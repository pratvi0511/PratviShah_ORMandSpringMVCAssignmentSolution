package com.greatlearning.customerManagement.service;

import java.util.List;

import com.greatlearning.customerManagement.controller.Customer;

public interface CustomerService{
	 public List<Customer> findAll();
	 
	 public Customer findById(int theId);
	 
	 public void save(Customer theCustomer);
	 
	 public void deleteById(int theId);
 }