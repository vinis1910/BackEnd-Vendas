package br.com.slloww.sa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.entities.Order;
import br.com.slloww.sa.repositories.OrderRepository;
import br.com.slloww.sa.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
}
