package com.app.test.inditext.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.test.inditext.model.Price;
import com.app.test.inditext.response.ConsultResponse;
import com.app.test.inditext.services.PriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired
	PriceService priceService;

	@Operation(summary = "Get tariff and final price to be applied to a specific brand of a specific product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return tariff and final price to be applied to a specific brand of a specific product"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Server Error") })
	@GetMapping("/v1/consult")
	public ResponseEntity<ConsultResponse> getTariffToApplyToProduct(@RequestParam String dateApplication,
			@RequestParam String productId, @RequestParam String brandId) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		Price price = this.priceService.getTariffToApplyToProduct(Long.valueOf(brandId), Long.valueOf(productId), LocalDateTime.parse(dateApplication, formatter));
		if (price != null) {
			ConsultResponse response = new ConsultResponse(price);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
