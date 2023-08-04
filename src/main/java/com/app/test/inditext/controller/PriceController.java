package com.app.test.inditext.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.test.inditext.request.PriceRequest;
import com.app.test.inditext.response.PriceResponse;
import com.app.test.inditext.services.PriceService;
 

@RestController
@RequestMapping("/api")
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
 
	@PostMapping("/prices")
    public ResponseEntity <PriceResponse> getPriceByProductAndApplicationDate(@RequestBody PriceRequest priceRequest){
		PriceResponse priceResponse = new PriceResponse(priceService.getTariffToApplyToProduct(priceRequest.getBrandId(), priceRequest.getProductId(), priceRequest.getApplyDate()));
		return ResponseEntity.ok().body(priceResponse);
    }

	
}
