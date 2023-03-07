package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.slloww.sa.DTOs.CustomerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "customer")
@Entity
public class Customer extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();

	public Customer() {
	}

	public Customer(Long id, String name, String email, String password, String phone) {
		super(id, name, email, password, phone);
		// TODO Auto-generated constructor stub
	}
	
	public Customer(CustomerDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.phone = dto.getPhone();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
