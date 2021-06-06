package com.vagai.salesproducts.repository;

import com.vagai.salesproducts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
