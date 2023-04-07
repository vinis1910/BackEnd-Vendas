package br.com.slloww.sa.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.entities.Admin;
import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.entities.Order;
import br.com.slloww.sa.entities.OrderProduct;
import br.com.slloww.sa.entities.Product;
import br.com.slloww.sa.entities.Seller;
import br.com.slloww.sa.enums.Categories;
import br.com.slloww.sa.repositories.AdminRepository;
import br.com.slloww.sa.repositories.CustomerRepository;
import br.com.slloww.sa.repositories.OrderProductRepository;
import br.com.slloww.sa.repositories.OrderRepository;
import br.com.slloww.sa.repositories.ProductRepository;
import br.com.slloww.sa.repositories.SellerRepository;

@Service
public class DBService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderProductRepository orderPRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Product p1 = new Product(null, "Pc", "descricao pc", new BigDecimal("2000.0"));
		p1.getCategories().add(Categories.COMPUTER);
		
		Admin a1 = new Admin(null, "Vinicius", "viniadm@gmail.com", encoder.encode("123"), "44988521221");
		
		Customer c1 = new Customer(null, "amanda", "amanda@gmail.com", encoder.encode("123"), "44988349911");
		
		Seller s1 = new Seller(null, "Vinicius G", "vinicius@gmail.com", encoder.encode("123"), "44988449911");
		
		Order o1 = new Order(c1, s1);
		
		OrderProduct op1 = new OrderProduct(3, p1, p1.getPrice(), o1);
		
		System.out.printf("SubTotal: %f\n",op1.getSubTotal());
		System.out.printf("Total: %f\n",o1.getTotal());
		
		
		adminRepository.saveAll(Arrays.asList(a1));
		sellerRepository.saveAll(Arrays.asList(s1));
		customerRepository.saveAll(Arrays.asList(c1));
		productRepository.saveAll(Arrays.asList(p1));
		orderRepository.saveAll(Arrays.asList(o1));
		orderPRepository.saveAll(Arrays.asList(op1));
		
	}
} 
