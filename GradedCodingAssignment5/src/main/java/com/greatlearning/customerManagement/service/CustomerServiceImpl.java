package com.greatlearning.customerManagement.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customerManagement.controller.Customer;


@Repository
public class CustomerServiceImpl implements CustomerService {
	
	private SessionFactory sessionFactory;

	//Create a session
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}
	
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		
		//Find all the record from the database table
		List<Customer> customers = session.createQuery("from Customer").list();
		
		tx.commit();
		 
		return customers;
	}

	@Transactional
	public Customer findById(int theId) {
		
		Customer customer = new Customer();
		
		Transaction tx = session.beginTransaction();
		
		//Find record with Id from the database table
		customer = session.get(Customer.class, theId);
		
		tx.commit();
		
		
		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theCustomer);
		
		tx.commit();
	}

	@Transactional
	public void deleteById(int theId) {
		 
		Transaction tx = session.beginTransaction();
		//Get transaction
		Customer customer = session.get(Customer.class, theId);
		
		//Delete record
		session.delete(customer);
		tx.commit();
	}
	
	//Print the loop
	@Transactional
	public void print(List<Customer> customer) {
		
		for(Customer c : customer) {
			System.out.println(c);
		}		
	}	
}
