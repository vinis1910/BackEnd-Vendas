package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}