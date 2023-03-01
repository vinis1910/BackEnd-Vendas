package br.com.slloww.sa.services;

import org.springframework.stereotype.Service;

import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.entities.Product;
import br.com.slloww.sa.entities.Seller;
import br.com.slloww.sa.enums.Categories;

@Service
public class DBService {

	public void instanciaDB() {
		
		Seller s1 = new Seller(null, "Vinicius G", "vinicius@gmail.com", "123", "44988449911");
		Customer c1 = new Customer(null, "amanda", "amanda@gmail.com", "123", "44988349911");
		
		Product p1 = new Product(null, "Pc", "descricao pc", 2000.00);
		p1.getCat().add(Categories.COMPUTER);
		System.out.println(p1.getCat());
	}
} 
