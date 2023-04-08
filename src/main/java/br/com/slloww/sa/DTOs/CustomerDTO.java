package br.com.slloww.sa.DTOs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.slloww.sa.entities.Customer;
import br.com.slloww.sa.enums.Profiles;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull(message = "O campo NOME está vazio")
	private String name;
	@NotNull(message = "O campo EMAIL está vazio")
	private String email;
	@NotNull(message = "O campo SENHA está vazio")
	private String password;
	@NotNull
	private String phone;
	@NotNull
	private Set<Integer> profiles = new HashSet<>();

	public CustomerDTO() {
		super();
		this.addPerfis(Profiles.CUSTOMER);
	}

	public CustomerDTO(Customer Customer) {
		super();
		this.id = Customer.getId();
		this.name = Customer.getName();
		this.email = Customer.getEmail();
		this.password = Customer.getPassword();
		this.phone = Customer.getPhone();
		addPerfis(Profiles.CUSTOMER);
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

	public Set<Profiles> getPerfis() {
		return profiles.stream().map(x -> Profiles.valueOf(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Profiles profile) {
		this.profiles.add(profile.getCode());
	}
}
