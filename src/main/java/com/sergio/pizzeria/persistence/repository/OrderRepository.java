package com.sergio.pizzeria.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.sergio.pizzeria.persistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

	List<OrderEntity> findAllByDateAfter(LocalDateTime date);

	List<OrderEntity> findAllByMethodIn(List<String> methods);

	@Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
	List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);

}
