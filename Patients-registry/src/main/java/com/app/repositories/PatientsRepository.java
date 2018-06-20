package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Patient;

@Repository
public interface PatientsRepository extends JpaRepository<Patient, Long> {

}
