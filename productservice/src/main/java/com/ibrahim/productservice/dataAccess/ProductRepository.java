package com.ibrahim.productservice.dataAccess;

import com.ibrahim.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
