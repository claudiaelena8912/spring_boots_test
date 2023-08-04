package com.app.test.inditext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.test.inditext.model.Price;
import com.app.test.inditext.repository.PriceRepository;

@DataJpaTest
public class PriceRepositoryUnitTest {

	@Autowired
	PriceRepository priceRepository;

	@Test
	public void should_get_tariff_to_apply_to_product_1() throws ParseException {
		Long brand_id = Long.valueOf(1);
		Long product_id = Long.valueOf(35455);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime apply_date = LocalDateTime.parse("2020-06-14 10:00:00", formatter);

		List<Price> prices = priceRepository.getTariffToApplyToProduct(brand_id, product_id, apply_date);

		assertEquals(1, prices.size());
		assertEquals(1, prices.get(0).getTariffToApply());
		assertEquals(35.5, prices.get(0).getValue());
		assertEquals(LocalDateTime.parse("2020-06-14 00:00:00", formatter), prices.get(0).getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31 23:59:59", formatter), prices.get(0).getEndDate());
	}

	@Test
	public void should_get_tariff_to_apply_to_product_2() throws ParseException {
		Long brand_id = Long.valueOf(1);
		Long product_id = Long.valueOf(35455);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime apply_date = LocalDateTime.parse("2020-06-14 16:00:00", formatter);

		List<Price> prices = priceRepository.getTariffToApplyToProduct(brand_id, product_id, apply_date);

		assertEquals(2, prices.size());
		assertEquals(2, prices.get(0).getTariffToApply());
		assertEquals(25.45, prices.get(0).getValue());
		assertEquals(LocalDateTime.parse("2020-06-14 15:00:00", formatter), prices.get(0).getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-14 18:30:00", formatter), prices.get(0).getEndDate());
	}

	@Test
	public void should_get_tariff_to_apply_to_product_3() throws ParseException {
		Long brand_id = Long.valueOf(1);
		Long product_id = Long.valueOf(35455);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime apply_date = LocalDateTime.parse("2020-06-14 21:00:00", formatter);

		List<Price> prices = priceRepository.getTariffToApplyToProduct(brand_id, product_id, apply_date);

		assertEquals(1, prices.size());
		assertEquals(1, prices.get(0).getTariffToApply());
		assertEquals(35.5, prices.get(0).getValue());
		assertEquals(LocalDateTime.parse("2020-06-14 00:00:00", formatter), prices.get(0).getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31 23:59:59", formatter), prices.get(0).getEndDate());
	}

	@Test
	public void should_get_tariff_to_apply_to_product_4() throws ParseException {
		Long brand_id = Long.valueOf(1);
		Long product_id = Long.valueOf(35455);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime apply_date = LocalDateTime.parse("2020-06-15 10:00:00", formatter);

		List<Price> prices = priceRepository.getTariffToApplyToProduct(brand_id, product_id, apply_date);

		assertEquals(2, prices.size());
		assertEquals(3, prices.get(0).getTariffToApply());
		assertEquals(30.5, prices.get(0).getValue());
		assertEquals(LocalDateTime.parse("2020-06-15 00:00:00", formatter), prices.get(0).getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-15 11:00:00", formatter), prices.get(0).getEndDate());
	}

	@Test
	public void should_get_tariff_to_apply_to_product_5() throws ParseException {
		Long brand_id = Long.valueOf(1);
		Long product_id = Long.valueOf(35455);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime apply_date = LocalDateTime.parse("2020-06-16 21:00:00", formatter);

		List<Price> prices = priceRepository.getTariffToApplyToProduct(brand_id, product_id, apply_date);

		assertEquals(2, prices.size());
		assertEquals(4, prices.get(0).getTariffToApply());
		assertEquals(38.95, prices.get(0).getValue());
		assertEquals(LocalDateTime.parse("2020-06-15 16:00:00", formatter), prices.get(0).getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31 23:59:59", formatter), prices.get(0).getEndDate());
	}

}
