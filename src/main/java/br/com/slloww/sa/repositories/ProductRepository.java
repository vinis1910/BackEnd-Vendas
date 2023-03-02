package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}