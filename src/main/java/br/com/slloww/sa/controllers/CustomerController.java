package br.com.slloww.sa.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.slloww.sa.DTOs.CustomerDTO;
import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.services.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll(){
		List<Customer> list = service.findAll();
		List<CustomerDTO> listDTO = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id){
		Customer customer = service.findById(id);
		return ResponseEntity.ok().body(new CustomerDTO(customer));
		
	}
	
	@PostMapping
	public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO obj){
		Customer newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(newObj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> update(@PathVariable Long id,@Valid @RequestBody CustomerDTO objDTO){
		Customer obj = service.update(id, objDTO); 
		return ResponseEntity.ok().body(new CustomerDTO(obj));
	}
}
