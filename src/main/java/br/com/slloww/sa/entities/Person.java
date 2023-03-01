package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.slloww.sa.enums.Perfis;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String name;

	@Column(unique = true)
	protected String email;
	protected String password;

	@Column(unique = true)
	protected String phone;

	@CollectionTable(name = "Perfis")
	protected Set<Integer> profiles = new HashSet<>();

	public Person() {
		super();
		this.setProfiles(Perfis.CLIENTE);
	}

	public Person(Long id, String name, String email, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.setProfiles(Perfis.CLIENTE);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Perfis> getProfiles() {
		return profiles.stream().map(x -> Perfis.valueOf(x)).collect(Collectors.toSet());
	}

	public void setProfiles(Perfis perfis) {
		this.profiles.add(perfis.getCode());
	}

}
