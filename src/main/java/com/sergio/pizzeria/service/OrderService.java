package com.sergio.pizzeria.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.pizzeria.persistence.entity.OrderEntity;
import com.sergio.pizzeria.persistence.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	private static final String DELIVERY = "D";
	private static final String CARRYOUT = "C";
	private static final String ON_SITE = "S";

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderEntity> getAll() {
		List<OrderEntity> orders = this.orderRepository.findAll();
		orders.forEach(o -> System.out.println(o.getCustomer().getName()));
		return orders;
	}

	public List<OrderEntity> getTodayOrders() {
		LocalDateTime today = LocalDate.now().atTime(0, 0);
		return this.orderRepository.findAllByDateAfter(today);
	}

	public List<OrderEntity> getOutsideOrders() {
		List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
		return this.orderRepository.findAllByMethodIn(methods);
	}

	public List<OrderEntity> getCustomerOrders(String idCustomer) {
		return this.orderRepository.findCustomerOrders(idCustomer);
	}

}
