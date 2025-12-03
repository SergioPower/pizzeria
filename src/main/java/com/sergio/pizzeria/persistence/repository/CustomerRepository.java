package com.sergio.pizzeria.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.sergio.pizzeria.persistence.entity.CustomerEntity;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {

	@Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")
	CustomerEntity finByPhone(@Param("phone") String phone);

}
