package com.app.test.inditext.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "BRANDS")
public class Brand implements Serializable{

	private static final long serialVersionUID = -1309676230241712447L;

	@Id
	@Column(name = "ID", columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "BRAND_NAME", columnDefinition = "VARCHAR")
	private String brandName;

	@OneToMany
    @JoinColumn(name = "brand_id")
    private Set<Price> prices;
	
	public Brand() {

	}
	
	public Brand(Long id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}



	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
