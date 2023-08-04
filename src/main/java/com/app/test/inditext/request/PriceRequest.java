package com.app.test.inditext.request;

import java.io.Serializable;
import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PriceRequest implements Serializable{

	private static final long serialVersionUID = 6449803162082224769L;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty("applyDate")
	private LocalDateTime applyDate;
	
	@JsonProperty("brandId")
	private Long brandId;
	
	@JsonProperty("productId")
	private Long productId;

	public PriceRequest() {
		super();
	}

	public PriceRequest(LocalDateTime applyDate, Long brandId, Long productId) {
		super();
		this.applyDate = applyDate;
		this.brandId = brandId;
		this.productId = productId;
	}

	public LocalDateTime getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
