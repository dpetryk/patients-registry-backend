package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Address;
import com.app.repositories.AddressesRepository;

@RestController
@RequestMapping("addresses")
public class AddressesController {

	@Autowired
	private AddressesRepository addressesRepository;

	@GetMapping
	public List<Address> list() {
		return addressesRepository.findAll();
	}

	@PostMapping
	public Address create(@RequestBody Address address) {
		return addressesRepository.saveAndFlush(address);
	}

	@GetMapping(value = "{id}")
	public Optional <Address> get(@PathVariable Long id) {
		return addressesRepository.findById(id);
	}

	@PutMapping(value = "{id}")
	public Address update(@PathVariable Long id, @RequestBody Address address) {
		Address existingAddress = addressesRepository.getOne(id);
		BeanUtils.copyProperties(address, existingAddress);
		return addressesRepository.saveAndFlush(existingAddress);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		Address existingAddress = addressesRepository.getOne(id);
		addressesRepository.delete(existingAddress);
	}

}
