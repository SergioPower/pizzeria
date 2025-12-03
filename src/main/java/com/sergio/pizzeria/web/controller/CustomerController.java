package com.sergio.pizzeria.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.pizzeria.persistence.entity.CustomerEntity;
import com.sergio.pizzeria.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/phone/{phone}")
	public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone) {
		return ResponseEntity.ok(this.customerService.findByPhone(phone));
	}

}
