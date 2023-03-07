package br.com.slloww.sa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.DTOs.ProductDTO;
import br.com.slloww.sa.entities.Product;
import br.com.slloww.sa.repositories.ProductRepository;
import br.com.slloww.sa.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product create(ProductDTO obj) {
		obj.setId(null);
		Product newObj = new Product(obj);
		return productRepository.save(newObj);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
}
