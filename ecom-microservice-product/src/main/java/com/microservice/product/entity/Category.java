package com.microservice.product.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Category extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7821605811509236238L;
	
	@NotBlank
	@Column(nullable=false)
	private String name;

	@OneToMany(mappedBy = "category")
	private Set<Product> products;
}
