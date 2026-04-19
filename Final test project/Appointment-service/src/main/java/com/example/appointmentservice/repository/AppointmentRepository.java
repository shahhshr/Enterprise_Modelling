package com.example.appointmentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.appointmentservice.model.Appointment;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

}