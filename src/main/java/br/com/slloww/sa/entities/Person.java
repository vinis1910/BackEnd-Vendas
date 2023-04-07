package br.com.slloww.sa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.slloww.sa.enums.Profiles;

@Entity
@Table(name = "person")
public abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@NotNull
	protected String name;

	@Column(unique = true)
	@NotNull
	protected String email;
	@NotNull
	protected String password;

	@Column(unique = true)
	@NotNull
	protected String phone;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "profiles")
	@NotNull
	protected Set<Integer> profiles = new HashSet<>();

	public Person() {
		super();
		this.setProfiles(Profiles.CUSTOMER);
	}

	public Person(Long id, String name, String email, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.setProfiles(Profiles.CUSTOMER);
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

	public Set<Profiles> getProfiles() {
		return profiles.stream().map(x -> Profiles.valueOf(x)).collect(Collectors.toSet());
	}

	public void setProfiles(Profiles perfis) {
		this.profiles.add(perfis.getCode());
	}

}
