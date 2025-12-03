package com.sergio.pizzeria.service;

import org.springframework.stereotype.Service;

import com.sergio.pizzeria.persistence.entity.CustomerEntity;
import com.sergio.pizzeria.persistence.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerEntity findByPhone(String phone) {
		return this.customerRepository.finByPhone(phone);
	}

}
