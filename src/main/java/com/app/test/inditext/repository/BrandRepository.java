package com.app.test.inditext.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.test.inditext.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
  
}
