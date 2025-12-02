package com.sergio.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.sergio.pizzeria.persistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

}
