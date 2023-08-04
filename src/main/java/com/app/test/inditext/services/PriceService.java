package com.app.test.inditext.services;




import java.time.LocalDateTime;

import com.app.test.inditext.model.Price;

public interface PriceService {
	
	Price getTariffToApplyToProduct(Long brandId, Long productId, LocalDateTime applyDate);
    
}
