package com.sergio.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRespository extends ListCrudRepository<PizzaEntity, Integer> {

}
