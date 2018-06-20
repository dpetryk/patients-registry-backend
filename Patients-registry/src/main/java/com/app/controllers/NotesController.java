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

import com.app.models.Note;
import com.app.repositories.NotesRepository;

@RestController
@RequestMapping(value="notes")
public class NotesController {
	
	@Autowired
	NotesRepository notesRepository;
	
	@GetMapping
	public List<Note> list(){
		return notesRepository.findAll();
	}
	
	@GetMapping(value="{id}")
	public Optional<Note> get(@PathVariable Long id) {
		return notesRepository.findById(id);
	}
	
	@PostMapping
	public Note create(@RequestBody Note note) {
		return notesRepository.saveAndFlush(note);
	}
	
	@PutMapping(value = "{id}")
	public Note update(@PathVariable Long id, @RequestBody Note note) {
		Note existingNote = notesRepository.getOne(id);
		BeanUtils.copyProperties(note, existingNote);
		return notesRepository.saveAndFlush(existingNote);
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		Note existingNote = notesRepository.getOne(id);
		notesRepository.delete(existingNote);
	}
}


