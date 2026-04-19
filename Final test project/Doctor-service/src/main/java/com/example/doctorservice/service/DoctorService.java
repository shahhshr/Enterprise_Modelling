package com.example.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // CREATE
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // READ ALL
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // READ BY ID
    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }

    // UPDATE
    public Doctor updateDoctor(String id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();

        doctor.setDoctorName(doctorDetails.getDoctorName());
        doctor.setDoctorEmail(doctorDetails.getDoctorEmail());
        doctor.setDoctorMobile(doctorDetails.getDoctorMobile());
        doctor.setSpecialization(doctorDetails.getSpecialization());

        return doctorRepository.save(doctor);
    }

    // DELETE
    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}