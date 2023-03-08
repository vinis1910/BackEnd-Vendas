package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.slloww.sa.DTOs.SellerDTO;
import br.com.slloww.sa.enums.Profiles;

@Entity
public class Seller extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "seller")
	private List<Order> orders = new ArrayList<>();

	public Seller() {
		this.setProfiles(Profiles.SELLER);
	}

	public Seller(Long id, String name, String email, String password, String phone) {
		super(id, name, email, password, phone);
		this.setProfiles(Profiles.SELLER);
	}
	
	public Seller(SellerDTO dto) {
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