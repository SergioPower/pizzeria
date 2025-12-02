package com.sergio.pizzeria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.pizzeria.persistence.entity.OrderEntity;
import com.sergio.pizzeria.persistence.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderEntity> getAll() {
		List<OrderEntity> orders = this.orderRepository.findAll();
		orders.forEach(o -> System.out.println(o.getCustomer().getName()));
		return orders;
	}

}
