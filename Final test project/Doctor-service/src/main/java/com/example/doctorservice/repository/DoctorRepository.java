package com.example.doctorservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.doctorservice.model.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

}