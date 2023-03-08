package br.com.slloww.sa.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.slloww.sa.DTOs.SellerDTO;
import br.com.slloww.sa.entities.Seller;
import br.com.slloww.sa.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	@Autowired
	private SellerService service;

	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<Seller> list = service.findAll();
		List<SellerDTO> listDTO = list.stream().map(obj -> new SellerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> findById(@PathVariable Long id) {
		Seller admin = service.findById(id);
		return ResponseEntity.ok().body(new SellerDTO(admin));
	}

	@PostMapping
	public ResponseEntity<SellerDTO> create(@Valid @RequestBody SellerDTO obj) {
		Seller newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(newObj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> update(@PathVariable Long id, @Valid @RequestBody SellerDTO objDTO) {
		Seller obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new SellerDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SellerDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
