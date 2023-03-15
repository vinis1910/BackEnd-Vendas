package br.com.slloww.sa.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.slloww.sa.DTOs.AdminDTO;
import br.com.slloww.sa.enums.Profiles;

@Entity
public class Admin extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Admin() {
		this.setProfiles(Profiles.ADMIN);
	}

	public Admin(Long id, String name, String email, String password, String phone) {
		super(id, name, email, password, phone);
		this.setProfiles(Profiles.ADMIN);
	}
	
	public Admin(AdminDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.phone = dto.getPhone();
	}
}