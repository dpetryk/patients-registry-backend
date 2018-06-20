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

import com.app.models.Visit;
import com.app.repositories.VisitsRepository;

@RestController
@RequestMapping(value = "visits")
public class VisitsController {

	@Autowired
	private VisitsRepository visitsRepository;

	@GetMapping
	public List<Visit> list() {
		return visitsRepository.findAll();
	}

	@PostMapping
	public Visit create(@RequestBody Visit visit) {
		return visitsRepository.saveAndFlush(visit);
	}

	@GetMapping(value = "{id}")
	public Optional<Visit> get(@PathVariable Long id) {
		return visitsRepository.findById(id);
	}

	@PutMapping(value = "{id}")
	public Visit update(@PathVariable Long id, @RequestBody Visit visit) {
		Visit existingVisit = visitsRepository.getOne(id);
		BeanUtils.copyProperties(visit, existingVisit);
		return visitsRepository.saveAndFlush(existingVisit);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		Visit existingVisit = visitsRepository.getOne(id);
		visitsRepository.delete(existingVisit);
	}
}
