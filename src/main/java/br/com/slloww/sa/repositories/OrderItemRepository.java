package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}