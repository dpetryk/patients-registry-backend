package com.app.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="notes")
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="note_id")
	private Long id;
	private String note;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
	private Date noteDate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="visit_id")
	private Visit visit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
}
