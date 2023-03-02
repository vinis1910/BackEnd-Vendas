package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}