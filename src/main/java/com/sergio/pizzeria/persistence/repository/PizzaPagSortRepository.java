package com.sergio.pizzeria.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {
	Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
}
