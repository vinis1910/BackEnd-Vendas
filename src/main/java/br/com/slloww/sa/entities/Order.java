package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.slloww.sa.enums.PaymentStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	@Column(name = "Date")
	@NotNull
	private LocalDateTime date = LocalDateTime.now();

	@OneToMany(mappedBy = "id.order")
	@NotNull
	private Set<OrderProduct> products = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "Customers")
	@NotNull
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "Seller")
	@NotNull
	private Seller seller;
	
	private PaymentStatus paymentStatus;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, Seller seller, PaymentStatus paymentStatus) {
		super();
		this.customer = customer;
		this.seller = seller;
		this.paymentStatus = paymentStatus;
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

	public Set<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(Set<OrderProduct> products) {
		this.products = products;
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

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public BigDecimal getTotal() {
	    return products.stream()
	    		.map(item -> item.getSubTotal())
	            .reduce(BigDecimal.ZERO, BigDecimal::add);
	}
  
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
