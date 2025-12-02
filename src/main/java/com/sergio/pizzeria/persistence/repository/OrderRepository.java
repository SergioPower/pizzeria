package com.sergio.pizzeria.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.sergio.pizzeria.persistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

	List<OrderEntity> findAllByDateAfter(LocalDateTime date);

	List<OrderEntity> findAllByMethodIn(List<String> methods);

}
