package com.microservice.product.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Brand extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7670760620223483105L;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	private String bio;
	
	private String logo;
	
	@OneToMany(mappedBy = "brand")
	private Set<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bio, logo, name, products);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(bio, other.bio) && Objects.equals(logo, other.logo) && Objects.equals(name, other.name)
				&& Objects.equals(products, other.products);
	}
	
}
