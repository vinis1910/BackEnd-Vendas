package br.com.slloww.sa.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.slloww.sa.DTOs.OrderDTO;
import br.com.slloww.sa.entities.Order;
import br.com.slloww.sa.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<Order> lista = service.findAll();
		List<OrderDTO> listaDTO = lista.stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
		Order user = service.findById(id);
		return ResponseEntity.ok().body(new OrderDTO(user));
		
	}
	
}
