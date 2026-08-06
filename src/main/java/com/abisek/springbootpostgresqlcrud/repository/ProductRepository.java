package com.abisek.springbootpostgresqlcrud.repository;

import com.abisek.springbootpostgresqlcrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
