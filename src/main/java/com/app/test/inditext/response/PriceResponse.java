package com.app.test.inditext.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.app.test.inditext.model.Price;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PriceResponse implements Serializable{

	private static final long serialVersionUID = 6708784511793277156L;
	
	@JsonProperty("productId")
	private Long productId;
	
	@JsonProperty("brandId")
	private Long brandId;
	
	@JsonProperty("tariffToApply")
	private Integer tariffToApply;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty("startDate")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty("endDate")
	private LocalDateTime endDate;
	
	@JsonProperty("price")
	private Double value;
	
	public PriceResponse() {
		super();
	}

	public PriceResponse(Long productId, Long brandId, Integer tariffToApply, LocalDateTime startDate, LocalDateTime endDate, Double value) {
		super();
		this.productId = productId;
		this.brandId = brandId;
		this.tariffToApply = tariffToApply;
		this.startDate = startDate;
		this.endDate = endDate;
		this.value = value;
	}
	
	
	public PriceResponse(Price price) {
		this.productId = price.getProductId();
		this.brandId = price.getBrand().getId();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.value = price.getValue();
		this.tariffToApply = price.getTariffToApply();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Integer getTariffToApply() {
		return tariffToApply;
	}

	public void setTariffToApply(Integer tariffToApply) {
		this.tariffToApply = tariffToApply;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
