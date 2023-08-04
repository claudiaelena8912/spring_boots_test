package com.app.test.inditext.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.test.inditext.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
