package com.app.test.inditext.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "PRICES")
public class Price implements Serializable{

	private static final long serialVersionUID = 3088057393230339650L;

	@Id
	@Column(name = "ID", columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "START_DATE", columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;

	@Column(name = "END_DATE", columnDefinition = "TIMESTAMP")
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST", columnDefinition = "INTEGER")
	private Integer tariffToApply;

	@Column(name = "PRODUCT_ID", columnDefinition = "BIGINT")
	private Long productId;

	@Column(name = "PRIORITY", columnDefinition = "INTEGER")
	private Integer priority;

	@Column(name = "PRICE", columnDefinition = "DOUBLE")
	private Double value;

	@Column(name = "CURR", columnDefinition = "VARCHAR")
	private String curr;
	
	@ManyToOne
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

	public Price() {
		super();
	}

	public Price(LocalDateTime startDate, LocalDateTime endDate, Integer tariffToApply, Long productId,
			 Double value, Brand brand) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.tariffToApply = tariffToApply;
		this.productId = productId;
		this.value = value;
		this.brand = brand;
	}
	

	public Price(LocalDateTime startDate, LocalDateTime endDate, Integer tariffToApply, Long productId,
			 Double value, String curr, Brand brand) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.tariffToApply = tariffToApply;
		this.productId = productId;
		this.value = value;
		this.brand = brand;
		this.curr = curr;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getTariffToApply() {
		return tariffToApply;
	}

	public void setTariffToApply(Integer tariffToApply) {
		this.tariffToApply = tariffToApply;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
