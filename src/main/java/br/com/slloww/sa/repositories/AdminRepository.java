package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}