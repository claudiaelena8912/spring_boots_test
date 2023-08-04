package com.app.test.inditext.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.test.inditext.model.Price;
import com.app.test.inditext.repository.PriceRepository;
import com.app.test.inditext.services.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceRepository priceRepository;

	@Override
	public Price getTariffToApplyToProduct(Long brandId, Long productId, LocalDateTime applyDate) {
		Price price = new Price();
		List<Price> prices = priceRepository.getTariffToApplyToProduct(brandId, productId, applyDate);
		if (prices != null && !prices.isEmpty()) {
			price = prices.get(0);
		}
		return price;
	}

}
