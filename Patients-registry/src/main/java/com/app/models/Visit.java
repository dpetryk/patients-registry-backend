package com.app.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name="visits")
public class Visit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="visit_id")
	private Long id;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date visitDate;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="visit_id")
	private List<Note> notes;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date date) {
		this.visitDate = date;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
