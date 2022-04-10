package com.greatlearning.customerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerManagement.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// add mapping for "/list"
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		//get customer from db
		List<Customer> theCustomers = customerService.findAll();
		
		//add to the spring model
		theModel.addAttribute("Customers", theCustomers);
		
		return "list-Customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("Customer", theCustomer);
		
		return "Customer-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		// get the Customer from the service
		Customer theCustomer = customerService.findById(theId);
		
		// set Customr as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);
		
		return "Customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,
								@RequestParam("first_Name") String firstName,
								@RequestParam("last_Name") String lastName,
								@RequestParam("email") String email) {
		
		System.out.println(id);
		System.out.println("firstName" + firstName);
		System.out.println("lastName" + lastName);
		Customer theCustomer ;
		if (id!=0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		}else {
			theCustomer = new Customer(firstName, lastName, email);
		}
		// save the customer
		customerService.save(theCustomer);
		
		// use a redirect to prevent duplicate submission
		return "redirect:/customers/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		//delete the Book
		customerService.deleteById(theId);
		
		// redirect to /Customers/list
		
		return "redirect:/customers/list";
	}
}
