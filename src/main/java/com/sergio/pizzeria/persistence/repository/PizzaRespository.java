package com.sergio.pizzeria.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRespository extends ListCrudRepository<PizzaEntity, Integer> {

	List<PizzaEntity> findByAvailableTrueOrderByPrice();

	PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
}
