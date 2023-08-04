package com.app.test.inditext.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable{

	private static final long serialVersionUID = 2310308418490048829L;

	@Id
	@Column(name = "ID", columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "PRODUCT_NAME", columnDefinition = "VARCHAR")
	private String productName;

	public Product() {

	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
