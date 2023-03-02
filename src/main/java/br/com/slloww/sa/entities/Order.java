package br.com.slloww.sa.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	@Column(name = "Date")
	private LocalDateTime date = LocalDateTime.now();

	@Column(name = "Items")
	@OneToMany
	private Set<OrderItem> items = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "Customers")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "Seller")
	private Seller seller;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, LocalDateTime date, Set<OrderItem> items, Customer customer, Seller seller) {
		super();
		this.id = id;
		this.date = date;
		this.items = items;
		this.customer = customer;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
