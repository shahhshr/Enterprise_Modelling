package com.example.appointmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.appointmentservice.model.Appointment;
import com.example.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RestTemplate restTemplate;

    // CREATE (with microservice communication)
    public Appointment addAppointment(Appointment appointment) {

        String patientUrl = "http://localhost:8081/patients/" + appointment.getPatientId();
        String doctorUrl = "http://localhost:8082/doctors/" + appointment.getDoctorId();

        try {
            Object patient = restTemplate.getForObject(patientUrl, Object.class);
            Object doctor = restTemplate.getForObject(doctorUrl, Object.class);

            if (patient == null || doctor == null) {
                throw new RuntimeException("Patient or Doctor not found");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error: Patient or Doctor service not reachable");
        }

        return appointmentRepository.save(appointment);
    }

    // READ ALL
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // READ BY ID
    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    // UPDATE
    public Appointment updateAppointment(String id, Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();

        appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
        appointment.setDescription(appointmentDetails.getDescription());
        appointment.setPatientId(appointmentDetails.getPatientId());
        appointment.setDoctorId(appointmentDetails.getDoctorId());

        return appointmentRepository.save(appointment);
    }

    // DELETE
    public void deleteAppointment(String id) {
        appointmentRepository.deleteById(id);
    }
}