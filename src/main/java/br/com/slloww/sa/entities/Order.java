package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	@Column(name = "Date")
	private LocalDateTime date = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "Customers")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "Seller")
	private Seller seller;

	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProduct;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, Seller seller, List<OrderProduct> orderProduct) {
		super();
		this.customer = customer;
		this.seller = seller;
		this.orderProduct = orderProduct;
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

	public List<OrderProduct> getOrderItem() {
		return orderProduct;
	}

	public void setOrderItem(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}

}
