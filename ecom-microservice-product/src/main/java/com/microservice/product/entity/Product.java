package com.microservice.product.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Product extends BaseModel {

	@NotBlank
	@Column(nullable=false)
	private String name;
	
	@NotBlank
	@Column(nullable=false)
	private String description;
	
	@NotBlank
	@Column(nullable=false)
	private Long quanity;
	
	@NotBlank
	@Column(nullable=false)
	private Float price;
	
	@NotBlank
	@Column(nullable=false)
	private String imageUrl;
	
	@NotBlank
	@Column(columnDefinition = "boolean default true")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="brand_id", nullable=false)
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	private Set<Coupon> coupons;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuanity() {
		return quanity;
	}

	public void setQuanity(Long quanity) {
		this.quanity = quanity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	

	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(brand, coupons, description, imageUrl, isActive, name, price, quanity);
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
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(coupons, other.coupons)
				&& Objects.equals(description, other.description) && Objects.equals(imageUrl, other.imageUrl)
				&& isActive == other.isActive && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(quanity, other.quanity);
	}

}
