package com.microservice.product.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Coupon extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8691461692893126092L;

	private String code;
	
	@Max(100)
	@Min(0)
	private float percentage;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "product_coupons", 
	joinColumns = {@JoinColumn(name="coupons_id")},
	inverseJoinColumns = {@JoinColumn(name = "product_id")}
	)
	private Set<Product> products;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
}
