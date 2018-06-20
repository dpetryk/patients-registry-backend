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

import com.app.models.Patient;
import com.app.repositories.PatientsRepository;

@RestController
@RequestMapping("patients")
public class PatientsController {

	@Autowired
	private PatientsRepository patientsRepository;

	@GetMapping
	public List<Patient> list() {
		return patientsRepository.findAll();
	}

	@PostMapping
	public Patient create(@RequestBody Patient patient) {
		return patientsRepository.saveAndFlush(patient);
	}

	@GetMapping(value = "{id}")
	public Optional <Patient> get(@PathVariable Long id) {
		return patientsRepository.findById(id);
	}

	@PutMapping(value = "{id}")
	public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
		Patient existingPatient = patientsRepository.getOne(id);
		BeanUtils.copyProperties(patient, existingPatient);
		return patientsRepository.saveAndFlush(existingPatient);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		Patient existingPatient = patientsRepository.getOne(id);
		patientsRepository.delete(existingPatient);
	}

}
