package com.example.patientservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.patientservice.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {
}