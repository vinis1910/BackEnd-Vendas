package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.OrderProduct;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}