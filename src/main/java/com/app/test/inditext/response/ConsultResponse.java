package com.app.test.inditext.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.app.test.inditext.model.Price;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultResponse implements Serializable {

	private static final long serialVersionUID = 8229896902950586039L;

	@JsonProperty("productId")
	private String productId;

	@JsonProperty("brandId")
	private String brandId;

	@JsonProperty("tariff")
	private String tariff;
	
	@JsonProperty("price")
	private String value;

	@JsonProperty("startDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;

	@JsonProperty("endDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;

	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConsultResponse() {
		super();
	}

	public ConsultResponse(String productId, String brandId, String tariff, LocalDateTime startDate, LocalDateTime endDate,
			String value) {
		super();
		this.productId = productId;
		this.brandId = brandId;
		this.tariff = tariff;
		this.startDate = startDate;
		this.endDate = endDate;
		this.value = value;
	}

	public ConsultResponse(Price price) {
		this.productId = price.getProductId().toString();
		this.brandId = price.getBrand().getId().toString();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.value = price.getValue().toString() + " " + price.getCurr();
		this.tariff = price.getTariffToApply().toString();
	}

}
