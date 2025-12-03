package com.sergio.pizzeria.service;

import com.sergio.pizzeria.persistence.entity.PizzaEntity;
import com.sergio.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.sergio.pizzeria.persistence.repository.PizzaRespository;
import com.sergio.pizzeria.service.dto.UpdatePizzaPriceDto;
import com.sergio.pizzeria.service.exception.EmailApiException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Page<PizzaEntity> getAvailablePizzas(int page, int elements, String sortBy, String sortDirection) {
		System.out.println(this.pizzaRespository.countByVeganTrue());

		Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
		Pageable pageReguest = PageRequest.of(page, elements, sort);
		return this.pizzaPagSortRepository.findByAvailableTrue(pageReguest);
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

	public void delete(int idPizza) {
		this.pizzaRespository.deleteById(idPizza);
	}

	@Transactional(noRollbackFor = EmailApiException.class)
	public void updatePrice(UpdatePizzaPriceDto dto) {
		this.pizzaRespository.updatePrice(dto);
		this.sendEmail();
	}

	private void sendEmail() {
		throw new EmailApiException();
	}

	public boolean exists(int idPizza) {
		return this.pizzaRespository.existsById(idPizza);
	}
}
