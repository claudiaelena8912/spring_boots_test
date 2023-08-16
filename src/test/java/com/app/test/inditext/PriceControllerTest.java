package com.app.test.inditext;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.test.inditext.controller.PriceController;
import com.app.test.inditext.model.Brand;
import com.app.test.inditext.model.Price;
import com.app.test.inditext.services.PriceService;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PriceService  priceService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Test
	public void getTest1() throws Exception {
		
		String expectedPriceResponseJson = "{\"productId\": \"35455\",\"brandId\": \"1\",\"tariff\": \"1\", \"price\": \"35.5 EUR\",\"startDate\": \"2020-06-14 00:00:00\",\"endDate\" : \"2020-12-31 23:59:59\"}";
		
		Price price = new Price(LocalDateTime.parse("2020-06-14 00:00:00", formatter),
				LocalDateTime.parse("2020-12-31 23:59:59", formatter), 1, Long.valueOf(35455), Double.valueOf("35.5"), "EUR",
				new Brand(Long.valueOf(1), "ZARA"));
		
		Mockito.when(this.priceService.getTariffToApplyToProduct(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(LocalDateTime.class))).thenReturn(price);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/consult")
				.param("dateApplication", "2020-06-14 10:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(expectedPriceResponseJson, result.getResponse().getContentAsString(), true);
		
	}
	
	@Test
	public void getTest2() throws Exception {
		
		String expectedPriceResponseJson = "{\"productId\": \"35455\",\"brandId\": \"1\",\"tariff\": \"2\", \"price\": \"25.45 EUR\",\"startDate\": \"2020-06-14 15:00:00\",\"endDate\" : \"2020-06-14 18:30:00\"}";
		
		Price price = new Price(LocalDateTime.parse("2020-06-14 15:00:00", formatter),
				LocalDateTime.parse("2020-06-14 18:30:00", formatter), 2, Long.valueOf(35455), Double.valueOf("25.45"), "EUR",
				new Brand(Long.valueOf(1), "ZARA"));
		
		Mockito.when(this.priceService.getTariffToApplyToProduct(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(LocalDateTime.class))).thenReturn(price);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/consult")
				.param("dateApplication", "2020-06-14 16:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(expectedPriceResponseJson, result.getResponse().getContentAsString(), true);
		
	}
	
	@Test
	public void getTest3() throws Exception {
		
		String expectedPriceResponseJson = "{\"productId\": \"35455\",\"brandId\": \"1\",\"tariff\": \"1\", \"price\": \"35.5 EUR\",\"startDate\": \"2020-06-14 00:00:00\",\"endDate\" : \"2020-12-31 23:59:59\"}";
		
		Price price = new Price(LocalDateTime.parse("2020-06-14 00:00:00", formatter),
				LocalDateTime.parse("2020-12-31 23:59:59", formatter), 1, Long.valueOf(35455), Double.valueOf("35.5"), "EUR",
				new Brand(Long.valueOf(1), "ZARA"));
		
		Mockito.when(this.priceService.getTariffToApplyToProduct(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(LocalDateTime.class))).thenReturn(price);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/consult")
				.param("dateApplication", "2020-06-14 21:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(expectedPriceResponseJson, result.getResponse().getContentAsString(), true);
		
	}

	@Test
	public void getTest4() throws Exception {
		
		String expectedPriceResponseJson = "{\"productId\": \"35455\",\"brandId\": \"1\",\"tariff\": \"3\", \"price\": \"30.5 EUR\",\"startDate\": \"2020-06-15 00:00:00\",\"endDate\" : \"2020-06-15 11:00:00\"}";
		
		Price price = new Price(LocalDateTime.parse("2020-06-15 00:00:00", formatter),
				LocalDateTime.parse("2020-06-15 11:00:00", formatter), 3, Long.valueOf(35455), Double.valueOf("30.5"), "EUR",
				new Brand(Long.valueOf(1), "ZARA"));
		
		Mockito.when(this.priceService.getTariffToApplyToProduct(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(LocalDateTime.class))).thenReturn(price);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/consult")
				.param("dateApplication", "2020-06-15 10:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(expectedPriceResponseJson, result.getResponse().getContentAsString(), true);
		
	}
	
	@Test
	public void getTest5() throws Exception {
		
		String expectedPriceResponseJson = "{\"productId\": \"35455\",\"brandId\": \"1\",\"tariff\": \"4\", \"price\": \"38.95 EUR\",\"startDate\": \"2020-06-15 00:00:00\",\"endDate\" : \"2020-06-15 11:00:00\"}";
		
		Price price = new Price(LocalDateTime.parse("2020-06-15 00:00:00", formatter),
				LocalDateTime.parse("2020-06-15 11:00:00", formatter), 4, Long.valueOf(35455), Double.valueOf("38.95"), "EUR",
				new Brand(Long.valueOf(1), "ZARA"));
		
		Mockito.when(this.priceService.getTariffToApplyToProduct(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.any(LocalDateTime.class))).thenReturn(price);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/consult")
				.param("dateApplication", "2020-06-16 21:00:00")
				.param("productId", "35455")
				.param("brandId", "1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(expectedPriceResponseJson, result.getResponse().getContentAsString(), true);
		
	}

}
