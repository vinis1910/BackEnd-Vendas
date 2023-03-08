package br.com.slloww.sa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.slloww.sa.DTOs.SellerDTO;
import br.com.slloww.sa.entities.Person;
import br.com.slloww.sa.entities.Seller;
import br.com.slloww.sa.repositories.PersonRepository;
import br.com.slloww.sa.repositories.SellerRepository;
import br.com.slloww.sa.services.exceptions.DataIntegrityViolationException;
import br.com.slloww.sa.services.exceptions.ObjectNotFoundException;

@Service
public class SellerService {
	@Autowired
	private SellerRepository SellerRepository;

	@Autowired
	private PersonRepository personRepository;

	public List<Seller> findAll() {
		return SellerRepository.findAll();
	}

	public Seller findById(Long id) {
		Optional<Seller> obj = SellerRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public Seller create(SellerDTO obj) {
		obj.setId(null);
		ValidationByTelAndEmail(obj);
		Seller newObj = new Seller(obj);
		return SellerRepository.save(newObj);
	}
	
	public Seller update(Long id, @Valid SellerDTO objDTO) {
		objDTO.setId(id);
		Seller oldObj = findById(id);
		ValidationByTelAndEmail(objDTO);
		oldObj = new Seller(objDTO);
		return SellerRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		Seller obj = findById(id);
		if(obj.getOrders().size() > 0) {
			throw new DataIntegrityViolationException("Sellers com pedidos existentes!");
		}
		SellerRepository.deleteById(id);
	}

	private void ValidationByTelAndEmail(SellerDTO objDTO) {
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
