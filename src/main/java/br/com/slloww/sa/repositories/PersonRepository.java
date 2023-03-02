package br.com.slloww.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}