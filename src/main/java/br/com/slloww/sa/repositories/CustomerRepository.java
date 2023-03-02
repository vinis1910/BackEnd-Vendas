package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}