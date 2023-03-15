package br.com.slloww.sa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.DTOs.AdminDTO;
import br.com.slloww.sa.entities.Admin;
import br.com.slloww.sa.entities.Person;
import br.com.slloww.sa.repositories.AdminRepository;
import br.com.slloww.sa.repositories.PersonRepository;
import br.com.slloww.sa.services.exceptions.DataIntegrityViolationException;
import br.com.slloww.sa.services.exceptions.ObjectNotFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	public Admin findById(Long id) {
		Optional<Admin> obj = adminRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public Admin create(AdminDTO obj) {
		obj.setId(null);
		obj.setPassword(encoder.encode(obj.getPassword()));
		ValidationByTelAndEmail(obj);
		Admin newObj = new Admin(obj);
		return adminRepository.save(newObj);
	}
	
	public Admin update(Long id, @Valid AdminDTO objDTO) {
		objDTO.setId(id);
		Admin oldObj = findById(id);
		ValidationByTelAndEmail(objDTO);
		oldObj = new Admin(objDTO);
		return adminRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		adminRepository.deleteById(id);
	}

	private void ValidationByTelAndEmail(AdminDTO objDTO) {
		Optional<Person> obj = personRepository.findByPhone(objDTO.getPhone());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = personRepository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
