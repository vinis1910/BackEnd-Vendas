package br.com.slloww.sa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.slloww.sa.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	Optional<Person> findByEmail(String email);
	Optional<Person> findByPhone(String telefone);
}