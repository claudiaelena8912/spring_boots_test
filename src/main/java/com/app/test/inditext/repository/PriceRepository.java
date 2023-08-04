package com.app.test.inditext.repository;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.test.inditext.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
	
	
	@Query(value = "SELECT * FROM PRICES p WHERE p.BRAND_ID = :brandId AND p.PRODUCT_ID = :productId AND p.START_DATE <= :applyDate AND p.END_DATE >= :applyDate ORDER BY p.PRIORITY DESC", nativeQuery = true)
	List<Price> getTariffToApplyToProduct(@Param("brandId") Long brandId, @Param("productId") Long productId, @Param("applyDate") LocalDateTime applyDate);
	
}
