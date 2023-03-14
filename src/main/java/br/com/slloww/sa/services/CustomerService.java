package br.com.slloww.sa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.DTOs.CustomerDTO;
import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.entities.Person;
import br.com.slloww.sa.repositories.CustomerRepository;
import br.com.slloww.sa.repositories.PersonRepository;
import br.com.slloww.sa.services.exceptions.DataIntegrityViolationException;
import br.com.slloww.sa.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(Long id) {
		Optional<Customer> obj = customerRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public Customer create(CustomerDTO obj) {
		obj.setId(null);
		obj.setPassword(encoder.encode(obj.getPassword()));
		ValidationByTelAndEmail(obj);
		Customer newObj = new Customer(obj);
		return customerRepository.save(newObj);
	}

	public Customer update(Long id, @Valid CustomerDTO objDTO) {
		objDTO.setId(id);
		Customer oldObj = findById(id);
		ValidationByTelAndEmail(objDTO);
		oldObj = new Customer(objDTO);
		return customerRepository.save(oldObj);
	}

	private void ValidationByTelAndEmail(CustomerDTO objDTO) {
		Optional<Person> obj = personRepository.findByPhone(objDTO.getPhone());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = personRepository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
