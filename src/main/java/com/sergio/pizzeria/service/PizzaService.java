package com.sergio.pizzeria.service;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;
import com.sergio.pizzeria.persistence.repository.PizzaRespository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
	private final PizzaRespository pizzaRespository;

	public PizzaService(PizzaRespository pizzaRespository) {
		this.pizzaRespository = pizzaRespository;
	}

	public List<PizzaEntity> getAll() {
		return this.pizzaRespository.findAll();
	}

	public List<PizzaEntity> getAvailablePizzas() {
		System.out.println(this.pizzaRespository.countByVeganTrue());
		return this.pizzaRespository.findByAvailableTrueOrderByPrice();
	}

	public PizzaEntity getByName(String name) {
		return this.pizzaRespository.findAllByAvailableTrueAndNameIgnoreCase(name);
	}

	public List<PizzaEntity> getWith(String ingredient) {
		return this.pizzaRespository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}

	public List<PizzaEntity> getWithout(String ingredient) {
		return this.pizzaRespository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
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
