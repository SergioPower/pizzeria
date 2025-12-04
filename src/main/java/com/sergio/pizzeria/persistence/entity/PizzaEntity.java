package com.sergio.pizzeria.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sergio.pizzeria.persistence.audit.AuditPizzaListener;
import com.sergio.pizzeria.persistence.audit.AuditableEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza")
@EntityListeners({ AuditingEntityListener.class, AuditPizzaListener.class })
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity extends AuditableEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;

	@Column(nullable = false, length = 30, unique = true)
	private String name;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private Double price;

	@Column(columnDefinition = "TINYINT")
	private Boolean vegetarian;

	@Column(columnDefinition = "TINYINT")
	private Boolean vegan;

	@Column(columnDefinition = "TINYINT", nullable = false)
	private Boolean available;

	@Column(name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	@Override
	public String toString() {
		return "PizzaEntity [idPizza=" + idPizza + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", vegetarian=" + vegetarian + ", vegan=" + vegan + ", available=" + available + "]";
	}

}
