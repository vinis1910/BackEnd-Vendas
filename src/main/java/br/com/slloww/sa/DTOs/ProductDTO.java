package br.com.slloww.sa.DTOs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.slloww.sa.entities.Product;
import br.com.slloww.sa.enums.Categories;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String description;
	private Double price;
	private String imaUrl;
	private Set<Categories> categories = new HashSet<>();

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Product product) {
		super();
		this.id = product.getId();
		this.nome = product.getName();
		this.description = product.getDesc();
		this.price = product.getPrice();
		this.categories = product.getCategories();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImaUrl() {
		return imaUrl;
	}

	public void setImaUrl(String imaUrl) {
		this.imaUrl = imaUrl;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

}
