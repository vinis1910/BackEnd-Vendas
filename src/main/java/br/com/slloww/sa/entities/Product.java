package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.slloww.sa.enums.Categories;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	@CollectionTable(name = "Categories")
	private Set<Categories> cat = new HashSet<>();

	public Product() {
		super();
	}

	public Product(Long id, String name, String desc, Double price, Set<Categories> cat) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.cat = cat;
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
