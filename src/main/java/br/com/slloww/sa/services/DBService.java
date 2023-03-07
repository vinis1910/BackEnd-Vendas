package br.com.slloww.sa.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.entities.Order;
import br.com.slloww.sa.entities.Product;
import br.com.slloww.sa.entities.Seller;
import br.com.slloww.sa.enums.Categories;
import br.com.slloww.sa.repositories.CustomerRepository;
import br.com.slloww.sa.repositories.OrderRepository;
import br.com.slloww.sa.repositories.ProductRepository;
import br.com.slloww.sa.repositories.SellerRepository;

@Service
public class DBService {

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	public void instanciaDB() {
		
		Seller s1 = new Seller(null, "Vinicius G", "vinicius@gmail.com", "123", "44988449911");
		Customer c1 = new Customer(null, "amanda", "amanda@gmail.com", "123", "44988349911");
		sellerRepository.saveAll(Arrays.asList(s1));
		customerRepository.saveAll(Arrays.asList(c1));
		
		Product p1 = new Product(null, "Pc", "descricao pc", 2000.00);
		p1.getCat().add(Categories.COMPUTER);
		productRepository.saveAll(Arrays.asList(p1));
			
		Order o1 = new Order(c1, s1);
		orderRepository.saveAll(Arrays.asList(o1));
		
	}
} 
