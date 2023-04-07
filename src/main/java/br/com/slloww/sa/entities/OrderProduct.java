package br.com.slloww.sa.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.slloww.sa.entities.pk.OrderProductPk;

@Entity
@Table(name = "OrderProduct")
public class OrderProduct {
	
	@EmbeddedId
	private OrderProductPk id = new OrderProductPk();
	
	private Integer quantity;
	private Double price;
	
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProduct(Integer quantity, Product product, Double price, Order order) {
		super();
		this.quantity = quantity;
		id.setOrder(order);
		id.setProduct(product);
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return quantity * price;
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
		OrderProduct other = (OrderProduct) obj;
		return Objects.equals(id, other.id);
	}
	
}
