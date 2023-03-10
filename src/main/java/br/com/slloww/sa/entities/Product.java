package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.slloww.sa.DTOs.ProductDTO;
import br.com.slloww.sa.enums.Categories;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String desc;
	private Double price;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Categories")
	private Set<Categories> cat = new HashSet<>();
	
	@ManyToOne
	private OrderProduct orderProducts;

	public Product() {
		super();
	}

	public Product(Long id, String name, String desc, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public Product(ProductDTO product) {
		super();
		this.id = product.getId();
		this.name = product.getNome();
		this.desc = product.getDescription();
		this.price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Categories> getCat() {
		return cat;
	}

	public void setCat(Set<Categories> cat) {
		this.cat = cat;
	}
}
