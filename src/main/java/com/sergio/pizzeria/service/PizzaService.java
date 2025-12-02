package com.sergio.pizzeria.service;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;
import com.sergio.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.sergio.pizzeria.persistence.repository.PizzaRespository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
	private final PizzaRespository pizzaRespository;
	private final PizzaPagSortRepository pizzaPagSortRepository;

	public PizzaService(PizzaRespository pizzaRespository, PizzaPagSortRepository pizzaPagSortRepository) {
		this.pizzaRespository = pizzaRespository;
		this.pizzaPagSortRepository = pizzaPagSortRepository;
	}

	public Page<PizzaEntity> getAll(int page, int elements) {
		Pageable pageReguest = PageRequest.of(page, elements);
		return this.pizzaPagSortRepository.findAll(pageReguest);
	}

	public List<PizzaEntity> getAvailablePizzas() {
		System.out.println(this.pizzaRespository.countByVeganTrue());
		return this.pizzaRespository.findByAvailableTrueOrderByPrice();
	}

	public PizzaEntity getByName(String name) {
		return this.pizzaRespository.findFirstByAvailableTrueAndNameIgnoreCase(name)
				.orElseThrow(() -> new RuntimeException("La pizza no existe"));
	}

	public List<PizzaEntity> getWith(String ingredient) {
		return this.pizzaRespository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}

	public List<PizzaEntity> getWithout(String ingredient) {
		return this.pizzaRespository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
	}

	public List<PizzaEntity> getCheapest(double price) {
		return this.pizzaRespository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
	}

	public PizzaEntity get(int idPizza) {
		return this.pizzaRespository.findById(idPizza).orElse(null);
	}

	public PizzaEntity save(PizzaEntity pizza) {
		return this.pizzaRespository.save(pizza);
	}

	public boolean exists(int idPizza) {
		return this.pizzaRespository.existsById(idPizza);
	}

	public void delete(int idPizza) {
		this.pizzaRespository.deleteById(idPizza);
	}
}
