package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Seller extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<Order> orders = new ArrayList<>();

	public Seller() {
	}

	public Seller(Long id, String name, String email, String password, String phone) {
		super(id, name, email, password, phone);
		// TODO Auto-generated constructor stub
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}