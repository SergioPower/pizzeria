package com.sergio.pizzeria.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRespository extends ListCrudRepository<PizzaEntity, Integer> {

	List<PizzaEntity> findByAvailableTrueOrderByPrice();

	Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

	List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

	int countByVeganTrue();

}
